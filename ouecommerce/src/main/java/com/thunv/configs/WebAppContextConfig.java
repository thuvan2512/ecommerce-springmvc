/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.configs;

import com.thunv.formatters.AgentFieldFormatter;
import com.thunv.formatters.CategoryFormatter;
import com.thunv.formatters.SaleStatusFormatter;
import com.thunv.service.UserService;
import com.thunv.service.impl.UserServiceImpl;
import com.thunv.validator.CommonAgencyValidator;
import com.thunv.validator.CommonItemValidator;
import com.thunv.validator.CommonSalePostValidator;
import com.thunv.validator.CommonUserValidator;
import com.thunv.validator.agency.AgencyAvatarValidator;
import com.thunv.validator.agency.AgentFieldValidator;
import com.thunv.validator.salepost.CategoryValidator;
import com.thunv.validator.salepost.SalePostAvatarValidator;
import com.thunv.validator.salepost.SaleStatusValidator;
import com.thunv.validator.user.EmailValidator;
import com.thunv.validator.user.FileAvatarValidator;
import com.thunv.validator.user.PasswordValidator;
import com.thunv.validator.user.UsernameValidator;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author thu.nv2512
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.thunv.controllers",
    "com.thunv.repository",
    "com.thunv.service",
    "com.thunv.utils",
    "com.thunv.validator",
    "com.thunv.social",})
public class WebAppContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
    }

//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver v = new InternalResourceViewResolver();
//        v.setPrefix("/WEB-INF/jsp/");
//        v.setSuffix(".jsp");
//        v.setViewClass(JstlView.class);
//
//        return v;
//    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("messages/messages");
        source.setDefaultEncoding("UTF-8");

        return source;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        return v;
    }
    @Autowired
    private UserService userService;

    @Bean
    public CommonUserValidator userValidator() {
        Set<Validator> springValidator = new HashSet<>();
        UsernameValidator usernameValidator = new UsernameValidator();
        usernameValidator.setUserService(this.userService);
        springValidator.add(usernameValidator);
        EmailValidator emailValidator = new EmailValidator();
        emailValidator.setUserService(this.userService);
        springValidator.add(emailValidator);
        springValidator.add(new FileAvatarValidator());
        springValidator.add(new PasswordValidator());
        CommonUserValidator commonUserValidator = new CommonUserValidator();
        commonUserValidator.setSpringValidators(springValidator);
        return commonUserValidator;
    }

    @Bean
    public CommonAgencyValidator agencyValidator() {
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new AgencyAvatarValidator());
        springValidator.add(new AgentFieldValidator());
        CommonAgencyValidator commonAgencyValidator = new CommonAgencyValidator();
        commonAgencyValidator.setSpringValidators(springValidator);
        return commonAgencyValidator;
    }
    @Bean
    public CommonSalePostValidator salePostValidator() {
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new SalePostAvatarValidator());
        springValidator.add(new SaleStatusValidator());
        springValidator.add(new CategoryValidator());
        CommonSalePostValidator salePostValidator = new CommonSalePostValidator();
        salePostValidator.setSpringValidators(springValidator);
        return salePostValidator;
    }
    @Bean
    public CommonItemValidator itemValidator() {
        Set<Validator> springValidator = new HashSet<>();
        CommonItemValidator itemValidator = new CommonItemValidator();
        itemValidator.setSpringValidators(springValidator);
        return itemValidator;
    }
    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addFormatter(new AgentFieldFormatter());
        registry.addFormatter(new CategoryFormatter());
        registry.addFormatter(new SaleStatusFormatter());
    }

}
