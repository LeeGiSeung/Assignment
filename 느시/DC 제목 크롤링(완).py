import requests
from urllib import request
from bs4 import BeautifulSoup

a = 1
count = 100

DC_File = open('DC_ratings.txt','a', encoding='UTF8')

while a<5800:
    BASE_URL = "https://gall.dcinside.com/mgallery/board/lists/?id=commercial_movie&page="+str(a)
    a = a + 1
    Domain_URL = "https://gall.dcinside.com"
    # 헤더 설정
    headers = [
    {'User-Agent' : 'Kimbab'},
    ]

    # html
    response = requests.get(BASE_URL, headers=headers[0])
    soup = BeautifulSoup(response.content, 'html.parser')
    html_list = soup.find('tbody').find_all('tr')

    # print(str(a)+"번째 페이지")

    for i in html_list:
        title_list = i.find('a', href=True).text # 제목
        URL_list = Domain_URL + i.find('a', href=True)['href'] # URL 주소
        DC_File.write(str(title_list)+"\n")
        # gall_list = i.find('strong').text # 갤이름
        # print(title_list)
    
        