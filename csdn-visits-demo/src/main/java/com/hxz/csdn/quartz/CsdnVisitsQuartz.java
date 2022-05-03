package com.hxz.csdn.quartz;

import com.alibaba.fastjson.JSON;
import com.hxz.csdn.config.CsdnVisitsConfig;
import com.hxz.csdn.entity.CsdnArticle;
import com.hxz.csdn.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 定时任务
 * @copyright &copy; DYH
 * @date 2022-05-03-19:08
 * @address 成都
 */
@Component
public class CsdnVisitsQuartz {
    private static final Logger log = LoggerFactory.getLogger(CsdnVisitsQuartz.class);
    @Autowired
    private CsdnVisitsConfig config;
    @Autowired
    private RestTemplate template;
    private Random random = new Random();
    private Integer page = 1;

    //    @Scheduled(cron = "0 0/10 7-23 * * ?")
    @Scheduled(cron = "0 0/2 * * * ?")
    public void test() {
        log.info("访问开始 ========> " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        page = 1;
        sendHttp();
    }

    private void sendHttp() {
        String url = config.getApiUrl() + "?page=" + page +
                "&size=" + config.getSize() + "&businessType=" + config.getBusinessType() +
                "&orderby=&noMore=false&year=&month=&username=" + config.getUsername();
        ResponseEntity<R> response = template.getForEntity(url, R.class);
        if (response.getStatusCode().value() == HttpStatus.OK.value()) {
            R r = response.getBody();
            if (r.getCode() == HttpStatus.OK.value()) {
                R.CsdnData data = r.getData();
                if (data.getTotal() > 0 && !ObjectUtils.isEmpty(data.getList())) {
                    List<CsdnArticle> articles = JSON.parseArray(JSON.toJSONString(data.getList()), CsdnArticle.class);
                    for (CsdnArticle article : articles) {
//                        try {
//                            Thread.sleep(getRandom() * 1000 * 10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        CompletableFuture.runAsync(()->{
                            template.getForEntity(article.getUrl(), String.class);
                            log.info("{}:访问路径：{}", data.getTotal(), article.getUrl());
                        });
                    }
                    page++;
//                    sendHttp();
                }
            }
        }
    }

    private int getRandom() {
        IntStream ints = random.ints(1, 5, 10);
        OptionalInt first = ints.findFirst();
        return first.getAsInt();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            IntStream ints = new Random().ints(1, 5, 10);
            OptionalInt first = ints.findFirst();
            int asInt = first.getAsInt() * 1000 * 10;
            try {
                Thread.sleep(asInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(asInt);
            log.info("访问开始 ========> " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
    }
}
