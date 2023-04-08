import requests
from bs4 import BeautifulSoup

url = 'https://news.naver.com/main/ranking/popularDay.nhn?rankingType=popular_day&date=20190430'

r = requests.get(url)
html = r.content
soup = BeautifulSoup(html, 'html.parser')
titles_html = soup.select('.ranking_section > ol > li > dl > dt > a')

for i in range(len(titles_html)):
    print(i+1, titles_html[i].text)