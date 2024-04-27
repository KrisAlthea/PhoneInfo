package me.haoran.phoneinfo.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baidubce.http.ApiExplorerClient;
import com.baidubce.http.AppSigner;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.ApiExplorerRequest;
import com.baidubce.model.ApiExplorerResponse;

import me.haoran.phoneinfo.model.NumInfo;
import me.haoran.phoneinfo.service.NumInfoService;
import org.springframework.stereotype.Service;

import static me.haoran.phoneinfo.constant.Constants.*;


/**
 * ClassName: NumInfoServiceImpl
 * Package: com.example.demo.service.impl
 * Description:
 *
 * @Author Haoran
 * @Create 4/25/2024 1:25 AM
 * @Version 1.0
 */
@Service
public class NumInfoServiceImpl implements NumInfoService {
	/**
	 * @param phoneNumber
	 * @return
	 */
	@Override
	public NumInfo getNumInfo (String phoneNumber) {

		ApiExplorerRequest request = new ApiExplorerRequest(HttpMethodName.GET, PATH);
		request.setCredentials(AccessKey, AppSecret);
		request.addHeaderParameter(HPKEY, HPVALUE);
		request.addQueryParameter(QPKEY, phoneNumber);

		ApiExplorerClient client = new ApiExplorerClient(new AppSigner());

		ApiExplorerResponse response = client.sendRequest(request);

		//System.out.println("返回的Json："+response.getResult());

		JSONObject jsonObject = JSONObject.parseObject(response.getResult());
		JSONObject dataObject = jsonObject.getJSONObject("data");

		// 当输入手机号未查询到时，dataObject 为null
		if (dataObject==null){
			return new NumInfo();
		}

		String city = dataObject.getString("city");
		String prov = dataObject.getString("prov");
		// System.out.println(city + " " + prov);
		return new NumInfo(city, prov);
	}
}
