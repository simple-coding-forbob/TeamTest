/**
 * 
 */
package egovframework.example.job.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author simple-coding
 * AI/빅데이터 데이터 처리하기: 수집 - 가공 - 적재 (3단계)
 * 데이터 수집 경로: c://Work/output/cooks.json 
 * 위의 경로에 파일을 저장할 경로를 만듭니다.
 */
@Log4j2
@Component
public class PublicApiJob {
	
    final String serviceKey = "INH5JlH9iuKNiuZVX2tblTV7m9CqLf0rNKopVhVq8vF0LpzZNp658j7xXeucRpukCmqE%2BekjfJk9g3%2BPWAGWZA%3D%3D";
    final String url = "https://api.odcloud.kr/api/15096711/v1/uddi:aa5a69ca-a427-4b7f-b5cd-d39d347f1327"
               + "?page=1&perPage=10&serviceKey=" + serviceKey;
	
    //10초마다
//    @Scheduled(cron = "*/10 * * * * ?")  // 10초마다
	@Scheduled(cron = "0 0 9 * * ?")     // 매일 9시 마다
    public void autoInsert() throws Exception {
//        log.info("테스트");
//      공공 데이터 포털: 부산관광공사_음식테마거리 음식점 이미지정보
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build(); // 데이터 요청
        Response response = client.newCall(request).execute();    // 결과 클래스(객체)
        String json=response.body().string();
    	log.info(json);                                           // 결과 데이터
    	
    	jsonWriter(json, "c://Work/output/cooks.json");           // 파일 쓰기 실행
    }
	
//	결과 데이터 파일로 쓰기 메소드
	public void jsonWriter(String json, String path) throws Exception {
    	// 결과 데이터를 파일로 저장: 파일이 있으면 덮어쓰기가 됩니다.
    	String filePath = path;
    	BufferedWriter writer = null;

    	try {
    	    writer = new BufferedWriter(new FileWriter(filePath));
    	    writer.write(json);
    	} catch (IOException e) {
    	    log.info("파일 오류 : "+e.toString());
    	} finally {
    	    if (writer != null) writer.close();
    	}
	}
}





