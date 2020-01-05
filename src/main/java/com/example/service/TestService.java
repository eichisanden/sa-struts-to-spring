package com.example.service;

import com.example.repository.EmpRepository;
import org.seasar.framework.container.SingletonS2Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.entity.Usr;
import tutorial.form.AddForm;

import java.util.List;

@Service
public class TestService {

    @Autowired
    EmpRepository empRepository;

    @Transactional
    public String hello() {
        AddForm form = SingletonS2Container.getComponent(AddForm.class);
        form.arg1 = "<form>";
        empRepository.save(new Usr(null, "hhhh"));
        List<Usr> list = empRepository.findAll();
        return "Hello From Service" + form.arg1;
    }
}
