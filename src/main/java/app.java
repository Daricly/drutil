import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dao.daoImpl.LeadDaoImpl;
import model.LeadModel;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class app {

    public final static String leadUrl = "https://hq.smm.cn/ajax/spot/history/201102250211/2020-09-02/2020-09-03";

    public final static String batUrl = "https://hq.smm.cn/ajax/spot/history/201503270005/2020-08-03/2020-09-03";

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(leadUrl);
        HttpGet batHttpGet = new HttpGet(batUrl);

        CloseableHttpResponse response = null;
        CloseableHttpResponse response1 = null;
        try {
            response = httpClient.execute(httpGet);
            response1 = httpClient.execute(batHttpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity responseEntity = response.getEntity();
        HttpEntity responseEntity1 = response1.getEntity();
        String content = null;
        String content1 = null;
        try {
            content = EntityUtils.toString(responseEntity);
            content1 = EntityUtils.toString(responseEntity1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSON.parseObject(content);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        JSONObject result = jsonArray.getJSONObject(29);

        JSONObject jsonObjectbat = JSON.parseObject(content1);
        JSONArray jsonArray1 = jsonObjectbat.getJSONArray("data");
        JSONObject result1 = jsonArray1.getJSONObject(29);

        LeadDaoImpl leadDao = new LeadDaoImpl();
        LeadModel leadModel = new LeadModel();
        leadModel.setDate(result.getString("renew_date"));
        leadModel.setAvg_lead_price(result.getDouble("average"));
        leadModel.setAvg_was_bat_price(result1.getDouble("average"));
        leadDao.insert(leadModel);
        System.out.println("成功");
    }
}
