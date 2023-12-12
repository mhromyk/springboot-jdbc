package mh.springboot.restapi.jdbc.repository;

import mh.springboot.restapi.jdbc.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase (product, price) VALUES( ?, ?)";

        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            return new Purchase(r.getInt("id"), r.getString("product"), r.getBigDecimal("price"));
        };

        return jdbc.query(sql, purchaseRowMapper);
    }

}
