package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave()
    {
        //Given
        Product product1 = new Product("Not");
        Product product2 = new Product("Found");
        Item item1 = new Item(product1, BigDecimal.ONE,9,new BigDecimal(34593));
        Item item2 = new Item(product2, new BigDecimal(808),300,new BigDecimal(44));
        List<Item> itemList = new ArrayList<>(List.of(item1,item2));
        Invoice invoice = new Invoice("404",itemList);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //When
        productDao.save(product1);
        productDao.save(product2);
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        Invoice findedInvoice = invoiceDao.findById(id).orElseThrow();
        assertEquals(2,findedInvoice.getItems().size());
        assertEquals("404",findedInvoice.getNumber());

        //Clean up
        invoiceDao.deleteById(id);
        productDao.deleteById(product1.getId());
        productDao.deleteById(product2.getId());
    }
}
