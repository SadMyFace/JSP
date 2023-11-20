package new02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Network03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// https://www.dorocy.co.kr/?da_ref=Yz1lb1RzVDI=&utm_source=Navar&utm_medium=cpc&utm_campaign=NaverbrandsearchPC&n_media=27758&n_query=%EB%8F%84%EB%A1%9C%EC%8B%9C&n_rank=1&n_ad_group=grp-a001-04-000000018119629&n_ad=nad-a001-04-000000273476731&n_keyword_id=nkw-a001-04-000003268010840&n_keyword=%EB%8F%84%EB%A1%9C%EC%8B%9C&n_campaign_type=4&n_contract=tct-a001-04-000000000802227&n_ad_group_type=5&NaPm=ct%3Dlp23xgrs%7Cci%3D0zq0003DU5nzxL3eefnZ%7Ctr%3Dbrnd%7Chk%3D20c24822ba509e803fd25ebf1872ca25377cc5b7
		URL url = null;
		BufferedReader input = null;
		String addr = "https://www.dorocy.co.kr/";
		
		String line = "";
		
		try {
			url = new URL(addr);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
