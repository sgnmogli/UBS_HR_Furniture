package hackerrank;

import java.util.HashMap;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private final HashMap<Furniture, Integer> furnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() 
    {
        furnitures = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) 
    {
       Integer count = 0;
        if(furnitures.containsKey(type)) 
        {
            count = furnitures.get(type);
        }
        furnitures.put(type, count + furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() 
    {
        return new HashMap<Furniture, Integer>(furnitures);
        return null;
    }

    public float getTotalOrderCost() 
    {
        if(!furnitures.isEmpty()) 
        {
        	return furnitures.entrySet().stream()
        			.map(f -> f.getKey().cost() * f.getValue())
        			.collect(Collectors.toList())
        			.stream()
        			.reduce(Float::sum)
        			.get();
        }
        return -1.0f;
    }

    public int getTypeCount(Furniture type) 
    {
        if(furnitures.containsKey(type)) 
        {
        	return furnitures.get(type);
        }
        return -1;
    }

    public float getTypeCost(Furniture type) 
    {
        if(furnitures.containsKey(type)) 
        {
        	return furnitures.get(type) * type.cost();
        }
        
        return -1.0f;
    }

    public int getTotalOrderQuantity() 
    {
        if(!furnitures.isEmpty()) 
        {
        	return furnitures.values().stream()
        			.reduce(Integer::sum)
        			.get();
        }
        return -1;
    }
}
