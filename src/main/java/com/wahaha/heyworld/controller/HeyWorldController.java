package com.wahaha.heyworld.controller;

import com.wahaha.heyworld.entity.Classes;
import com.wahaha.heyworld.entity.Fields;
import com.wahaha.heyworld.entity.Methods;
import com.wahaha.heyworld.util.Api;
import com.wahaha.heyworld.util.ApiOperation;
import com.wahaha.heyworld.util.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class HeyWorldController {

    @Autowired
    @RequestMapping(value = "/a")
    public ModelAndView HeyWorldController() {

       ModelAndView modelAndView = new ModelAndView();

       Method[] methods = null;
        Classes cla = new Classes();
        List<Classes> classesList = new ArrayList<>();
        List<Methods> methodsList = new ArrayList<>();
        Reflections reflections = new Reflections("com.example.heyworld.*");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Api.class);
        for (Class classe : classSet) {
            Api api = (Api) classe.getAnnotation(Api.class);
            String str = classe.getName();
            String className = str.substring(str.indexOf(".", str.indexOf(".",
                    str.indexOf(".", str.indexOf(".") + 1) + 1) + 1) + 1);
            cla.setClassName(className);
            cla.setDescription(api.tags());
            methods = classe.getDeclaredMethods();
            for (Method method : methods) {
                Methods meth = new Methods();
                List<Fields> fieldsList = new ArrayList<>();
                if (method.isAnnotationPresent(ApiOperation.class)) {
                    RequestMapping getMapping = method.getAnnotation(RequestMapping.class);
                    ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
                    meth.setPath(StringUtils.join(getMapping.value(), "/"));
                    meth.setMethodName(method.getName());
                    meth.setDescription(apiOperation.value());
                    Parameter[] parameter = method.getParameters();
                    for (Parameter parm : parameter) {
                        Fields fields = new Fields();
                        if (parm.isAnnotationPresent(ApiParam.class)) {
                            ApiParam apiParam = parm.getAnnotation(ApiParam.class);
                            fields.setFieldName(parm.getName());
                            fields.setType(apiParam.type());
                            fieldsList.add(fields);
                        }
                    }
                    meth.setFieldList(fieldsList);
                }
                methodsList.add(meth);
            }
            cla.setMethodsList(methodsList);

            classesList.add(cla);
        }
        modelAndView.addObject("classes", classesList);
        modelAndView.setViewName("HeyWorld");
        return modelAndView;
    }

}
