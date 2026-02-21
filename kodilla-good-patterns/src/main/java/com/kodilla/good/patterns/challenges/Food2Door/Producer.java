package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.HashMap;
import java.util.Map;

public abstract class Producer {
    protected String companyName;
    protected Map<String,Integer> productStock ;

    public String getCompanyName() {
        return companyName;
    }

    public Map<String,Integer> getProductStock() {
        return new HashMap<>(productStock);
    }

    public abstract OrderDTO process(Order order);

    public boolean checkIfOrderIsPossible(Order order)
    {
        for(Map.Entry<String,Integer> entry : order.productStock.entrySet())
        {
            Integer value = productStock .get(entry.getKey());
            if(value == null || value < entry.getValue())
            {
                return false;
            }
        }
        return true;
    }
}
