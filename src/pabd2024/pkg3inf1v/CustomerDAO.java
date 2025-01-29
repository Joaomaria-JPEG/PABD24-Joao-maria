
package pabd2024.pkg3inf1v;

import java.sql.* ;

public class CustomerDAO {
    
    private Connection con;
    
    public CustomerDAO() throws SQLException{
                this.con = new ConnectionFactory().getConnection();
                System.out.println("Connection OK");
    }
    
    public void insertCustomer(Customer c) throws SQLException{
                String sql ="insert into customer"
                  + "(store_id, first_name, last_name, email, address_id, active)"
                  + "values"
                  + "(?,? ,? ,? ,? ,?) ";
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt(1,c.getStore_id());
        pst.setString(2,c.getFirst_name());
        pst.setString(3, c.getLast_name());
        pst.setString(4,c.getEmail());
        pst.setInt(5,c.getAddress_id());
        pst.setInt(6,c.getActive());
        
        pst.execute();
        pst.close();

        System.out.println("Insert OK");
    }
    
    public void deleteCustomer(int id) throws SQLException{
        String sql ="delete from customer "
                + "wherw customer_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();
        pst.close();
        System.out.println("Delete Ok");
    }
    
    public void updateCustomer(int id) throws SQLException{
        String sql ="update  customer"
                  + "set store_id = ?, first_name = ? , last_name = ?, email = ?, address_id = ?, active = ? "
                  + "where customer_id = ? ";
        
        PreparedStatement pst = con.prepareStatement(sql);
        Customer c = new Customer(60, "Joao", "neto", "joao.rocha@gmail.com", 12, 1);
        pst.setInt(1,c.getStore_id());
        pst.setString(2,c.getFirst_name());
        pst.setString(3, c.getLast_name());
        pst.setString(4,c.getEmail());
        pst.setInt(5,c.getAddress_id());
        pst.setInt(6,c.getActive());
        
        pst.execute();
        pst.close();
    }
    
    public void showCustomer() throws SQLException{
        Statement st = con.createStatement();
        
        String query = "select * from customer order by customer_id desc  limit 5 ";
        
        ResultSet rs = st.executeQuery(query);

        ResultSetMetaData md = rs.getMetaData();
        
        int col = md.getColumnCount();
        
        System.out.println("Table, "+md.getTableName(1));
        
        for (int i = 1; i <= col; i++) {
            
            System.out.print(md.getColumnName(i) + "\t");
        }
        
        System.out.println();
        
        while (rs.next()) {
            
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");

            }
            
            System.out.println();
        }
        
        st.close();

    }
}
