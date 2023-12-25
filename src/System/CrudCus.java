package System;
import Users.Customer;

public interface CrudCus extends Crud<Customer>
{
    void list_orders( );
}
