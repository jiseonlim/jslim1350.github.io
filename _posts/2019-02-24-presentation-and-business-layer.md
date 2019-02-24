---
category: 'NHN ent.'
path: 'NHN ent./:id'
title: 'presentation layer and business layer'

layout: nil
---



# 서론

 프로젝트를 진행하며 지속적으로 피드백 받은 사항이 presentation layer와 business layer를 구분하라는 것이었다. 웹 기술(httpservletrequest, cookie 등)을 business layer에서 사용한 것이 문제였다. 사실 피드백 받기 전에는 이렇게 레이어를 구분한다는 것 자체를 알지 못해서 개념을 찾아보고 글을 쓰게 되었다. (우아하게 개발하기란 정말 어려운 것 같다!)



# Multitier architecture

 multitier architecture란 client-server 구조에서 사용자에게 보여지는 부분(presentation), 실제 어플리케이션이 동작하는 부분(application processing), 그리고 데이터를 처리하는 부분(data management)을 물리적으로 나누는 것이다.

 어플리케이션을 여러 티어로 분리함으로써 개발자는 좀 더 유연하고 재사용 가능한 어플리케이션을 만들 수 있다. 요구사항이 변경되었거나 유지보수가 필요할 때 전체 어플리케이션을 고칠 필요 없이 특정 레이어를 수정/추가하는 것으로 충분하다.

 가장 일반적인 방식은 3-tier architecture로 presentation tier, domain logic tier, data storage tier가 여기에 포함된다. 웹 개발에서 자주 사용되는 용어인 front-end(ex. browser), middle(ex. spring, NET, Node.js), back-end(ex. database)가 이를 적용한 것이다.



# Layers

 물리적으로 구분하는 티어와 다르게 레이어는 구조를 논리적으로 구분한다. 여러 레이어는 하나의 티어로 구성될 수 있다. 일반적으로 presentation layer, application layer, business layer, data access layer 4가지로 구분한다. 여기서는 presentation layer와 business layer에 대해서만 다룬다.

## presentation layer

 일명 UI layer, view layer라고 불리며 사용자가 직접적으로 접근하는 부분이다. 웹 브라우저나 쉘 등 각 상황에 맞게 보여주는 역할을 한다. 따라서 httpservletrequest, httpservletresponse, model, view, cookie 등 특정 기술은 여기서 사용해야 한다.

``` java
@Controller
public class ReadMailController {
    @Autowired
    private ReadMailService readMailService;	// connect with business layer
    
    @GetMapping("/readmail")
    public ModelAndView readMail(@RequestParam("emailId") int emailId, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();

        ReadMailDTO readMailDTO = readMailService.createReadMailDTO(emailId);
        modelAndView.addObject("readMailDTO", readMailDTO);
        modelAndView.setViewName("mailbox/readmail");

        return modelAndView;
    }    
}
```



## business layer

 데이터를 어떻게 만들고, 저장하고, 사용할지 결정하는 실제 세상의 비지니스 룰을 프로그래밍하는 부분이다. 어떤 환경에서도 재사용이 가능해야 하기 때문에 웹 기술과 같은 특정 기술은 여기서 사용하지 않는다.

``` java
@Service
public class ReadMailService {
    @Autowired
    private ReadMailMapper readMailMapper;	// connect with data acess layer
    
	public ReadMailDTO createReadMailDTA(int emailId){
    	ReadMailDTO readMailDTO = readMailMapper.findMail(emailId);
        
        return readMailDTO;
	}   
}
```



## 느낀점

 처음에는 controller와 service를 왜 분리해서 사용하는지조차 몰랐었는데 이렇게 조사하고 보니 잘 짜인 구조를 만들기 위해서라는 것을 알게 되었다. 어떻게 하면 더 유연하고 재사용 가능한 코드를 만들 수 있을지 항상 고민해야겠다.



# 참고

https://en.wikipedia.org/wiki/Multitier_architecture

https://en.wikipedia.org/wiki/Business_logic