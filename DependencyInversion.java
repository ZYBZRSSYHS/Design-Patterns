package cn.Design_Pattern;

public class DependencyInversion {

    public static void main(String[] args)
    {
        Customer wang = new Customer();
        System.out.println("顾客购买的商品：");
        wang.shopping(new ShaoguanShop());
        wang.shopping(new WuyuanShop());
    }
}

interface Shop
{
    public String sell();
}

class ShaoguanShop implements Shop
{
    public String sell()
    {
        return "ShaoguanShop";
    }
}

class WuyuanShop implements Shop
{
    public String sell()
    {
        return "WuyuanShop";
    }
}

class Customer
{
    public void shopping(Shop shop)
    {
        System.out.println(shop.sell());
    }
}