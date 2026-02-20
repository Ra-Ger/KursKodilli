package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.List;

public abstract class Producer {
    protected String companyName;
    protected List<Product> productList;

    public String getCompanyName() {
        return companyName;
    }

    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }

    public abstract OrderDTO process(Order order);

    public boolean checkIfOrderIsPossible(Order order)
    {
        for(Product product : order.getProductOrderList())
        {
            for(int i = 0; i < productList.size(); i++)
            {
                if(productList.get(i).getKindOfProduct().equals(product.getKindOfProduct()))
                {
                    if(productList.get(i).getAvailableAmount() >= product.getAvailableAmount())
                    {
                        break;
                    }
                    else return false; // nie ma wystarczajoncej ilosci
                }

                if(i >= productList.size() -1)
                    return false; // nie znaleziono produktu
            }
        }
        return true;
    }
}
