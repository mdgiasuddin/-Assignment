package com.babl.demointgr;

import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.CountryInfoServiceSoapType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test(){
        return testService.test();
    }

    @GetMapping("/country")
    public String getCountryDetails(){
        CountryInfoService _countryService = new CountryInfoService();
        CountryInfoServiceSoapType countryInfoServiceSoapType = _countryService.getCountryInfoServiceSoap();
        String countryName = countryInfoServiceSoapType.countryName("BD");
        String language = countryInfoServiceSoapType.languageName("BD");
        String phoneCode = countryInfoServiceSoapType.countryIntPhoneCode("BD");
        String capital = countryInfoServiceSoapType.capitalCity("BD");
        String flag = countryInfoServiceSoapType.countryFlag("BD");


        return "Country Name : " + countryName + "\n" +
                "Capital : " + capital + "\n" +
                "Language : " + language + "\n" +
                "Phone Code : " + phoneCode + "\n" +
                "Flag : " + flag;
    }

    @PostMapping("/testPost")
    public Map testPost(@RequestBody PostBody postBody){
        return testService.postTest(postBody);
    }
}
