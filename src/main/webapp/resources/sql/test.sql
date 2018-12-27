select count(*) as totalCount from criminal;

select name, sido, gungu, realResidence, `addDate`
from criminal
order by `addDate`;
#페이징
int totalCount = 25;
int countPage = 10;
int page = 3;
int startCount = (page - 1) * countPage + 1 ;
int endCount = page * countPage;

select name, sido, gungu, realResidence, `addDate`
from criminal
order by name
limit 0, 10;