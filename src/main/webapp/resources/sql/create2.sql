create table creducational (
	`no` int not null,
	`범죄분류` varchar(20) not null,
	`불취학` int(20) not null,
	`초등학교(재중)` int(20) not null,
	`초등학교(중퇴)` int(20) not null,
	`초등학교(졸업)` int(20) not null,
	`중학교(재중)` int(20) not null,
	`중학교(중퇴)` int(20) not null,
	`중학교(졸업)` int(20) not null,
	`고등학교(재중)` int(20) not null,
	`고등학교(중퇴)` int(20) not null,
	`고등학교(졸업)` int(20) not null,
	`대학(4년미만)(재중)` int(20) not null,
	`대학(4년미만)(중퇴)` int(20) not null,
	`대학(4년미만)(졸업)` int(20) not null,
	`대학(4년이상)(재중)` int(20) not null,
	`대학(4년이상)(중퇴)` int(20) not null,
	`대학(4년이상)(졸업)` int(20) not null,
	`대학원(재중)` int(20) not null,
	`대학원(중퇴)` int(20) not null,
	`대학원(졸업)` int(20) not null,
	`기타` int(20) not null,
	`미상` int(20) not null
);

create table crtime (
	`no` int not null,
	`범죄분류` varchar(20) not null,
	`00:00-02:59` int(20) not null,
	`03:00-05:59` int(20) not null,
	`06:00-08:59` int(20) not null,
	`09:00-11:59` int(20) not null,
	`12:00-14:59` int(20) not null,
	`15:00-17:59` int(20) not null,
	`18:00-20:59` int(20) not null,
	`21:00-23:59` int(20) not null,
	`미상` int(20) not null
);

create table crday (
	`no` int not null,
	`범죄분류` varchar(20) not null,
	`일` int(20) not null,
	`월` int(20) not null,
	`화` int(20) not null,
	`수` int(20) not null,
	`목` int(20) not null,
	`금` int(20) not null,
	`토` int(20) not null
);

create table crarea (
	`no` int not null,
	`범죄분류` varchar(20) not null,
	`아파트,연립다세대` int(20) not null,
	`단독주택` int(20) not null,
	`고속도로` int(20) not null,
	`노상` int(20) not null,
	`백화점` int(20) not null,
	`슈퍼마켓` int(20) not null,
	`편의점` int(20) not null,
	`대형할인매장` int(20) not null,
	`상점` int(20) not null,
	`시장,노점` int(20) not null,
	`숙박업소,목욕탕` int(20) not null,
	`유흥접객업소` int(20) not null,
	`사무실` int(20) not null,
	`공장` int(20) not null,
	`공사장,광산` int(20) not null,
	`창고` int(20) not null,
	`역,대합실` int(20) not null,
	`지하철` int(20) not null,
	`기타표통수단내` int(20) not null,
	`흥행장` int(20) not null,
	`유원지` int(20) not null,
	`학교` int(20) not null,
	`금융기관` int(20) not null,
	`의료기관` int(20) not null,
	`종교기관` int(20) not null,
	`산야` int(20) not null,
	`해상` int(20) not null,
	`부대` int(20) not null,
	`구금장소` int(20) not null,
	`공지` int(20) not null,
	`주차장` int(20) not null,
	`공중화장실` int(20) not null,
	`피씨방` int(20) not null,
	`기타` int(20) not null
);

create table crjob (
	`no` int not null,
	`범죄분류` varchar(20) not null,
	`자영업(농.임.수산업)` int(20) not null,
	`자영업(광업)` int(20) not null,
	`자영업(제조업)` int(20) not null,
	`자영업(건설업)` int(20) not null,
	`자영업(도.소매업)` int(20) not null,
	`자영업(무역업)` int(20) not null,
	`자영업(요식업)` int(20) not null,
	`자영업(숙박업)` int(20) not null,
	`자영업(유흥업)` int(20) not null,
	`자영업(금융업)` int(20) not null,
	`자영업(부동산업)` int(20) not null,
	`자영업(의료보건업)` int(20) not null,
	`자영업(차량정비업)` int(20) not null,
	`자영업(노점)` int(20) not null,
	`자영업(행상)` int(20) not null,
	`자영업(기타사업)` int(20) not null,
	`피고용자(교원(사립))` int(20) not null,
	`피고용자(사무원)` int(20) not null,
	`피고용자(기술자)` int(20) not null,
	`피고용자(점원)` int(20) not null,
	`피고용자(공원)` int(20) not null,
	`피고용자(운전사)` int(20) not null,
	`피고용자(경비원)` int(20) not null,
	`피고용자(외판원)` int(20) not null,
	`피고용자(국공영기업체직원)` int(20) not null,
	`피고용자(일반회사원)` int(20) not null,
	`피고용자(금융기관직원)` int(20) not null,
	`피고용자(유흥업종사자)` int(20) not null,
	`피고용자(요식업종사자)` int(20) not null,
	`피고용자(일용노동자)` int(20) not null,
	`피고용자(기타피고용자)` int(20) not null,
	`전문직(의사)` int(20) not null,
	`전문직(변호사)` int(20) not null,
	`전문직(교수)` int(20) not null,
	`전문직(종교가)` int(20) not null,
	`전문직(언론인)` int(20) not null,
	`전문직(예술인)` int(20) not null,
	`전문직(기타전문직)` int(20) not null,
	`공무원` int(20) not null,
	`기타(학생)` int(20) not null,
	`기타(주부)` int(20) not null,
	`기타(전경.의경)` int(20) not null,
	`기타(공익요원)` int(20) not null,
	`기타(기타)` int(20) not null,
	`무직자` int(20) not null,
	`미상` int(20) not null
);

create table crmotive (
	`no` int not null,
	`범죄분류` varchar(20) not null,
	`이욕(생활비)` int(20) not null,
	`이욕(유흥비)` int(20) not null,
	`이욕(도박비)` int(20) not null,
	`이욕(허영사치심)` int(20) not null,
	`이욕(치부)` int(20) not null,
	`이욕(기타)` int(20) not null,
	`사행심` int(20) not null,
	`보복` int(20) not null,
	`가정불화` int(20) not null,
	`호기심` int(20) not null,
	`유혹` int(20) not null,
	`우발적` int(20) not null,
	`현실불만` int(20) not null,
	`부주의` int(20) not null,
	`기타` int(20) not null,
	`미상` int(20) not null
);

create table crhideout (
	`no` int not null,
	`범죄분류` varchar(20) not null,
	`자기집` int(20) not null,
	`공범집` int(20) not null,
	`애인집` int(20) not null,
	`친족집` int(20) not null,
	`지인집` int(20) not null,
	`숙박업소` int(20) not null,
	`야외` int(20) not null,
	`현장검거` int(20) not null,
	`외국` int(20) not null,
	`기타` int(20) not null,
	`미상` int(20) not null
);

create table crAS (
	`no` int not null,
	`범죄분류` varchar(20) not null,
	`남자(20세이하)` int(20) not null,
	`남자(21-30세)` int(20) not null,
	`남자(31-40세)` int(20) not null,
	`남자(41-50세)` int(20) not null,
	`남자(51-60세)` int(20) not null,
	`남자(61-70세)` int(20) not null,
	`남자(71세이상)` int(20) not null,
	`남자(미상)` int(20) not null,
	`여자(20세이하)` int(20) not null,
	`여자(21-30세)` int(20) not null,
	`여자(31-40세)` int(20) not null,
	`여자(41-50세)` int(20) not null,
	`여자(51-60세)` int(20) not null,
	`여자(61-70세)` int(20) not null,
	`여자(71세이상)` int(20) not null,
	`여자(미상)` int(20) not null
);