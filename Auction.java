import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 7.0
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> listOfLots;
    // The number that will be given to the next lot entered into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        listOfLots = new ArrayList<>();
        nextLotNumber = 1;
        enterLot("a");
        enterLot("b");
        enterLot("c");
        enterLot("d");
        enterLot("e");
        makeABid(1, new Person("Emmanuel"), 1000);
        makeABid(3, new Person("Emmanuel E"), 2000);
        makeABid(5, new Person("Emmanuel Emejulu"), 1500);

    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        listOfLots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot aLot : listOfLots) {
            System.out.println(aLot.toString());
        }
    }
    
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            boolean successful = selectedLot.bidFor(new Bid(bidder, value));
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null if a lot with this 
     * number does not exist.
     * @param lotNumber The number of the lot to return.
     * @return The lot with the given number, or null.
     */

    public Lot getLot(int lotNumber)
    { // answer to question 3 for each
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            for(Lot aLot : listOfLots) {
                if (aLot.getNumber() == lotNumber) {
                    return aLot;
            }
        }
        System.out.println("Lot number: "+ lotNumber+ "seems to have been removed."); 
        return null;
    }
    else {
        System.out.println("Lot number: " + lotNumber+ " is invalid.");
        return null;
    }
}

public void closeAuction()
{ // question 3 for each
            for(Lot aLot : listOfLots) {
                Bid highest = aLot.getHighestBid();
                if(highest == null) {
                    System.out.println("Lot number " + aLot.getNumber() + "has yet to be bidded on ");
                }else{
                    System.out.println("The highest bid on lot number " + aLot.getNumber() + " was " + highest.getValue());
                    System.out.println("The bidder was " + highest.getBidder().getName());  
                }
            }
        }
                
public void closeAuctions()
{  //question 4 itterators
    Iterator<Lot> it = listOfLots.iterator();
    while (it.hasNext()){
        Lot lot = it.next();
        if (lot.getHighestBid() != null) {
            System.out.println(lot.getHighestBid().getBidder().getName() + " won the bid on lot number " + lot.getNumber() + " with a bet of " + lot.getHighestBid().getValue());
        } else {
                 System.out.println("Lot number " + lot.getNumber() + " has yet to be bidded on");
            }
        }
    }

        public ArrayList<Lot> getUnsoldLots()
        //SOLUTION TO QUESTION 4 PART II USING FOR-EACH LOOPS
        {
        ArrayList<Lot> unsold = new ArrayList<>();
        for (Lot aLot : listOfLots) {
            Bid highest = aLot.getHighestBid();
            if (highest == null) {
                unsold.add(aLot);
            }
        }
        return unsold;
    }
 public ArrayList<Lot> getUnsold()
 // SOLUTION TO QUESTION 4 PART II USING ITERATORS
    {
        ArrayList<Lot> unsoldList = new ArrayList<>();
        Iterator<Lot> it = listOfLots.iterator();
        while (it.hasNext()) {
            Lot l = it.next();
            if (l.getHighestBid() == null) {
                unsoldList.add(l);
            }
        }
        return unsoldList;
    }
        //SOLUTION TO QUESTION 7 PART II
        public Lot removeLot(int number)
        {
        Iterator<Lot> it = listOfLots.iterator();
        while (it.hasNext()) {
            Lot l = it.next();
            if (l.getNumber() == number) {
                it.remove();
                return l;
            }
        }
        return null;
    }
}

      
