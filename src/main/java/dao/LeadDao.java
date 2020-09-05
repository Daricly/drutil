package dao;

import model.LeadModel;

import java.util.List;

public interface LeadDao {
    public void insert(LeadModel leadModel);
    public void batchInsert(List<LeadModel> leadModelList);
}
