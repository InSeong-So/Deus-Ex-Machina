create table column_list (
    `no` int,
    `viewNm` varchar(20),
    `type` varchar(20),
    `value` varchar(30),
    `column` varchar(30)
);

insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','string','범죄분류','범죄분류');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','아파트,연립다세대','아파트,연립다세대');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','단독주택','단독주택');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','고속도로','고속도로');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','노상','노상');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','백화점','백화점');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','슈퍼마켓','슈퍼마켓');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','편의점','편의점');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','대형할인매장','대형할인매장');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','상점','상점');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','시장,노점','시장,노점');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','숙박업소,목욕탕','숙박업소,목욕탕');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','유흥접객업소','유흥접객업소');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','사무실','사무실');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','공장','공장');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','공사장,광산','공사장,광산');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','창고','창고');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','역,대합실','역,대합실');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','지하철','지하철');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','기타표통수단내','기타표통수단내');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','흥행장','흥행장');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','유원지','유원지');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','학교','학교');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','금융기관','금융기관');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','의료기관','의료기관');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','종교기관','종교기관');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','산야','산야');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','해상','해상');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','부대','부대');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','구금장소','구금장소');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','공지','공지');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','주차장','주차장');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','공중화장실','공중화장실');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','피씨방','피씨방');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crarea','number','기타','기타');




select `type`, `value`, `column` from column_list where viewNm = 'crarea';


column_listinsert into column_list (`viewNm`, `type`, `value`, `column`) values ('crtime','string','범죄분류','범죄분류');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crtime','number','00:00-02:59','00:00-02:59');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crtime','number','03:00-05:59','03:00-05:59');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crtime','number','06:00-08:59','06:00-08:59');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crtime','number','09:00-11:59','09:00-11:59');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crtime','number','12:00-14:59','12:00-14:59');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crtime','number','15:00-17:59','15:00-17:59');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crtime','number','18:00-20:59','18:00-20:59');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crtime','number','21:00-23:59','21:00-23:59');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crtime','number','미상','미상');


insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','string','범죄분류','범죄분류');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','이욕(생활비)','이욕(생활비)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','이욕(유흥비)','이욕(유흥비)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','이욕(도박비)','이욕(도박비)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','이욕(허영사치심)','이욕(허영사치심)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','이욕(치부)','이욕(치부)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','이욕(기타)','이욕(기타)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','사행심','사행심');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','보복','보복');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','가정불화','가정불화');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','호기심','호기심');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','유혹','유혹');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','우발적','우발적');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','현실불만','현실불만');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','부주의','부주의');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','기타','기타');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crmotive','number','미상','미상');


insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','string','범죄분류','범죄분류');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(농.임.수산업)','자영업(농.임.수산업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(광업)','자영업(광업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(제조업)','자영업(제조업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(건설업)','자영업(건설업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(도.소매업)','자영업(도.소매업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(무역업)','자영업(무역업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(요식업)','자영업(요식업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(숙박업)','자영업(숙박업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(유흥업)','자영업(유흥업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(금융업)','자영업(금융업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(부동산업)','자영업(부동산업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(의료보건업)','자영업(의료보건업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(차량정비업)','자영업(차량정비업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(노점)','자영업(노점)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(행상)','자영업(행상)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','자영업(기타사업)','자영업(기타사업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(교원(사립))','피고용자(교원(사립))');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(사무원)','피고용자(사무원)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(기술자)','피고용자(기술자)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(점원)','피고용자(점원)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(공원)','피고용자(공원)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(운전사)','피고용자(운전사)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(경비원)','피고용자(경비원)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(외판원)','피고용자(외판원)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(국공영기업체직원)','피고용자(국공영기업체직원)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(일반회사원)','피고용자(일반회사원)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(금융기관직원)','피고용자(금융기관직원)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(유흥업종사자)','피고용자(유흥업종사자)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(요식업종사자)','피고용자(요식업종사자)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(일용노동자)','피고용자(일용노동자)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','피고용자(기타피고용자)','피고용자(기타피고용자)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','전문직(의사)','전문직(의사)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','전문직(변호사)','전문직(변호사)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','전문직(교수)','전문직(교수)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','전문직(종교가)','전문직(종교가)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','전문직(언론인)','전문직(언론인)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','전문직(예술인)','전문직(예술인)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','전문직(기타전문직)','전문직(기타전문직)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','공무원','공무원');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','기타(학생)','기타(학생)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','기타(주부)','기타(주부)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','기타(전경.의경)','기타(전경.의경)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','기타(공익요원)','기타(공익요원)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','기타(기타)','기타(기타)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','무직자','무직자');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crjob','number','미상','미상');


insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','string','범죄분류','범죄분류');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','자기집','자기집');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','공범집','공범집');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','애인집','애인집');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','친족집','친족집');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','지인집','지인집');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','숙박업소','숙박업소');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','야외','야외');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','현장검거','현장검거');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','외국','외국');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','기타','기타');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crhideout','number','미상','미상');


insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','string','범죄분류','범죄분류');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','불취학','불취학');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','초등학교(재중)','초등학교(재중)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','초등학교(중퇴)','초등학교(중퇴)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','초등학교(졸업)','초등학교(졸업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','중학교(재중)','중학교(재중)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','중학교(중퇴)','중학교(중퇴)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','중학교(졸업)','중학교(졸업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','고등학교(재중)','고등학교(재중)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','고등학교(중퇴)','고등학교(중퇴)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','고등학교(졸업)','고등학교(졸업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','대학(4년미만)(재중)','대학(4년미만)(재중)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','대학(4년미만)(중퇴)','대학(4년미만)(중퇴)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','대학(4년미만)(졸업)','대학(4년미만)(졸업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','대학(4년이상)(재중)','대학(4년이상)(재중)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','대학(4년이상)(중퇴)','대학(4년이상)(중퇴)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','대학(4년이상)(졸업)','대학(4년이상)(졸업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','대학원(재중)','대학원(재중)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','대학원(중퇴)','대학원(중퇴)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','대학원(졸업)','대학원(졸업)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','기타','기타');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('creducational','number','미상','미상');


insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crday','string','범죄분류','범죄분류');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crday','number','일','일');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crday','number','월','월');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crday','number','화','화');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crday','number','수','수');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crday','number','목','목');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crday','number','금','금');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('crday','number','토','토');


insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','string','범죄분류','범죄분류');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','남자(20세이하)','남자(20세이하)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','남자(21-30세)','남자(21-30세)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','남자(31-40세)','남자(31-40세)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','남자(41-50세)','남자(41-50세)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','남자(51-60세)','남자(51-60세)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','남자(61-70세)','남자(61-70세)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','남자(71세이상)','남자(71세이상)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','남자(미상)','남자(미상)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','여자(20세이하)','여자(20세이하)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','여자(21-30세)','여자(21-30세)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','여자(31-40세)','여자(31-40세)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','여자(41-50세)','여자(41-50세)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','여자(51-60세)','여자(51-60세)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','여자(61-70세)','여자(61-70세)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','여자(71세이상)','여자(71세이상)');
insert into column_list (`viewNm`, `type`, `value`, `column`) values ('cras','number','여자(미상)','여자(미상)');
