package dao.daoImpl;

import dao.LeadDao;
import dataSource.DruidUtils;
import model.LeadModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class LeadDaoImpl implements LeadDao {
    @Override
    public void insert(LeadModel leadModel) {
        String sql = "insert into c_manually_lead_price (`date`, `avg_lead_price`, `avg_was_bat_price`) values (?,?,?)";
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Object[] values = new Object[]{leadModel.getDate(), leadModel.getAvg_lead_price(), leadModel.getAvg_was_bat_price()};
        try {
            queryRunner.insert(sql, new ScalarHandler<>(), values);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void batchInsert(List<LeadModel> leadModelList) {

    }
}
