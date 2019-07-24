package com.ecommerce.controller;

import com.ecommerce.exception.ResourceConflictException;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.helper.storage.StorageService;
import com.ecommerce.model.*;
import com.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.Entity;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by oa on 6/14/2019.
 */

@RestController
public class ECommerceRestController
{
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    StockService stockService;

    @Autowired
    StorageService storageService;

    @Autowired
    BrandService brandService;


    @Autowired
    OrderService orderService;
    @Autowired
    CustomerService customerService;






    @Autowired
    LoginService loginService;


    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<Login> saveLogin(@RequestBody  Login login)
    {

        loginService.save(login);
        return  new ResponseEntity<Login>(login,HttpStatus.CREATED);

    }






    @RequestMapping(value="/login",method =RequestMethod.GET)
    public ResponseEntity<List<Login>> findAllLogins()
    {
        List<Login> loginList= loginService.findByAll();

        return  new ResponseEntity<List<Login>>(loginList,HttpStatus.FOUND);
    }




    @RequestMapping(value="/login-validate",method =RequestMethod.POST)
    public ResponseEntity<Login> validate(@RequestBody Login login)
    {
        Login login1= loginService.findById(login.getId());

        return  new ResponseEntity<Login>(login1,HttpStatus.FOUND);
    }











    @RequestMapping(value="/order", method = RequestMethod.POST)
    public ResponseEntity<Order> saveOrder(@RequestBody  Order order)
    {

        orderService.save(order);
        return  new ResponseEntity<Order>(order,HttpStatus.CREATED);

    }


    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)
    {
        customerService.save(customer);
        return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);


    }















@RequestMapping(value="/brands",method =RequestMethod.GET)
    public ResponseEntity<List<Brand>> findAllBrands()
    {
          List<Brand> brandList= brandService.findAll();

          return  new ResponseEntity<List<Brand>>(brandList,HttpStatus.FOUND);
    }


    @RequestMapping(value="/brands",method =RequestMethod.POST)
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand)
    {

        brandService.save(brand);
        return  new ResponseEntity<Brand>(brand,HttpStatus.CREATED);

    }

    @RequestMapping(value ="/brand/{id}", method=RequestMethod.GET)
    public ResponseEntity<Brand> findBrandById(@PathVariable Long id)
    {
        return new ResponseEntity<Brand>(brandService.findById(id),HttpStatus.FOUND);
    }







    @RequestMapping(method = POST, value = "/category")
    public ResponseEntity<?> addCategory(@RequestBody Category category,
                                         UriComponentsBuilder ucBuilder) {
        Category category1=categoryService.findByName(category.getName());
        if (category1 != null)
        {
            throw new ResourceConflictException(category1.getId(), "already exists");
        }
        Category parentCategory=categoryService.findByName(category.getParentCategoryName());
        category1=category;
        category1.setParentCategory(parentCategory);
        try {
            category1 = categoryService.save(category1);
        }
        catch(Exception e ){e.printStackTrace();}
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/pos/{userId}").buildAndExpand(category1.getId()).toUri());
        return new ResponseEntity<Category>(category, HttpStatus.CREATED);
    }

    @RequestMapping(method = DELETE, value = "/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id)
    {
        categoryService.delete(Long.parseLong(id));
        return  ResponseEntity.ok(true);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category")
    public ResponseEntity<?> findAllCategories()
    {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{id}")
    public ResponseEntity<?> findByCategoryId(@PathVariable String id)
    {
        return  ResponseEntity.ok(categoryService.findById(Long.parseLong(id)));
    }






    @RequestMapping(method = POST, value = "/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product,
                                         UriComponentsBuilder ucBuilder) {
        Product product1=productService.findByName(product.getName());
        if (product1 != null)
        {
            throw new ResourceConflictException(product1.getId(), "already exists");
        }
        try {
            Category category =categoryService.findByName(product.getCategoryName());
            product.setCategory(category);
            product1 = productService.save(product);
        }
        catch(Exception e ){e.printStackTrace();}
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/pos/{userId}").buildAndExpand(product1.getId()).toUri());
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @RequestMapping(method = DELETE, value = "/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id)
    {
        productService.delete(Long.parseLong(id));
        return  ResponseEntity.ok(true);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product")
    public ResponseEntity<?> findAllProducts()
    {
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public ResponseEntity<?> findProductById(@PathVariable String id)
    {
        return  ResponseEntity.ok(productService.findById(Long.parseLong(id)));
    }









//start of stock
@RequestMapping(method =RequestMethod.GET, value = "/stock-new")
public ResponseEntity<?> findLastStockId()
{
    //String bn="BRD"+(brandService.findTopByOrderByIdDesc().getId()+1);
    if(stockService.findTopByOrderByIdDesc()==null)
    {
        return  ResponseEntity.ok("1");
    }
    return  ResponseEntity.ok("\""+(stockService.findTopByOrderByIdDesc().getId()+1l)+"\"");
}


    @RequestMapping(method = POST, value = "/stock")
    public ResponseEntity<?> addStocks(@RequestBody Stock stocks,
                                       UriComponentsBuilder ucBuilder) {
        Stock stocks1=null;
        if(stocks.getId()!=null)
            stocks1= stockService.findById(stocks.getId());
        if (stocks1 != null) {
            throw new ResourceConflictException(stocks.getId(), "already exists");
        }
        stocks1=stocks;
        if(stocks.getProductName()!=null)
        {
            Product product = productService.findByName(stocks.getProductName());
           // stocks1.setProduct(product);
        }




        stocks1 = stockService.save(stocks1);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/pos/{userId}").buildAndExpand(stocks1.getId()).toUri());
        return new ResponseEntity<Stock>(stocks1, HttpStatus.CREATED);
    }




    @RequestMapping(method = PUT, value = "/stock")
    public ResponseEntity<?> updateStocks(@RequestBody Stock stocks,
                                          UriComponentsBuilder ucBuilder) {
        Stock stocks1=stockService.findById(stocks.getId());
        if (stocks1 == null) {
            throw new ResourceNotFoundException(stocks.getId(), "dont exists");
        }
        stocks1=stocks;
        if(stocks.getProductName()!=null)
        {
            Product product = productService.findByName(stocks.getProductName());
           // stocks.setProduct(product); todo
        }
        stocks1 = stockService.save(stocks);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/pos/{userId}").buildAndExpand(stocks1.getId()).toUri());
        return new ResponseEntity<Stock>(stocks1, HttpStatus.CREATED);
    }


    @RequestMapping(method = PUT, value = "/stock-qty/{name}/{qty}")
    public ResponseEntity<?> updateStocksQty(@PathVariable("name") String productName,@PathVariable Integer qty,
                                             UriComponentsBuilder ucBuilder) {
        Stock stocks1=stockService.findByproduct(productService.findByName(productName));
        int newQty=stocks1.getQuantity()-qty;
        if(newQty<1)
        {
            throw new ResourceNotFoundException(stocks1.getId(), "Insufficient Quantity");
        }
        stocks1.setQuantity(newQty);
        stocks1 = stockService.save(stocks1);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/pos/{userId}").buildAndExpand(stocks1.getId()).toUri());
        return new ResponseEntity<Stock>(stocks1, HttpStatus.CREATED);
    }



    @RequestMapping(method = DELETE, value = "/stock/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable String id)
    {
        stockService.delete(Long.parseLong(id));
        return  ResponseEntity.ok(true);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/stock")
    public ResponseEntity<?> findAllStocks()
    {
        return ResponseEntity.ok(stockService.findAll());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/stock/{id}")
    public ResponseEntity<?> findByStocksId(@PathVariable String id)
    {
        return  ResponseEntity.ok(stockService.findById(Long.parseLong(id)));
    }






    @RequestMapping(value = "/image/{id}",method = RequestMethod.GET,  produces = "image/bmp")
    public Resource texture(@PathVariable("id") String id) {
        Resource file = storageService.loadAsResource(id+".png");
        return  file;//resourceLoader.getResource("classpath:images/" + id);
    }


    @RequestMapping(value = "/image/{entity-id}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable("entity-id") String id, RedirectAttributes redirectAttributes)
    {
        storageService.store(file,id);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        //return "redirect:/";
        return ResponseEntity.ok(1);
    }














}
