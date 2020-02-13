package com.babl.demointgr;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {

    public String test(){
        return "OK";
    }

    public Map postTest(PostBody postBody){
        Map map = new HashMap();
        map.put("a", postBody.getA());
        map.put("b", postBody.getB());
        map.put("c", postBody.getA()*postBody.getB());
        return map;
    }
}
