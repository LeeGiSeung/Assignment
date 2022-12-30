import requests
from urllib import request
from bs4 import BeautifulSoup

a = 1
b = 340836
c = 10
count = 100

while a<10:
    BASE_URL = "https://gall.dcinside.com/mgallery/board/view/?id=commercial_movie&no="+str(b-a)+"&page="+str(a)
    a = a + 1
    Domain_URL = "https://gall.dcinside.com"
    # 헤더 설정
    headers = [
    {'User-Agent' : ''},
    ]

    # html
    response = requests.get(BASE_URL, headers=headers[0])
    soup = BeautifulSoup(response.content, 'html.parser')
    html_list = soup.find('write_div').find_all('p')
    

    # print(str(a)+"번째 페이지")

    for i in html_list:
        title_list = i.find('p', href=True) # 제목
        # URL_list = Domain_URL + i.find('a', href=True)['href'] # URL 주소
        # gall_list = i.find('strong').text # 갤이름
        print(title_list)
    
        