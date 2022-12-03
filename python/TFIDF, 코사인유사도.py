from itertools import count
from tkinter.tix import COLUMN
from itertools import count
import tweepy
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.feature_extraction.text import TfidfVectorizer
import pandas as pd
import numpy as np
from numpy import dot
from numpy.linalg import norm
import os
import pandas as pd # 데이터프레임 사용을 위해
from math import log # IDF 계산을 위해
from tqdm import tqdm
from sklearn.metrics.pairwise import cosine_similarity
import openpyxl
pd.set_option('display.max_seq_items', None)
pd.set_option('display.max_rows', None)
pd.set_option('display.max_columns', None)

# 정수 인코딩
from nltk.tokenize import sent_tokenize
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords

# from wordcloud import WordCloud
import matplotlib.pyplot as plt
from collections import Counter
from konlpy.tag import Okt
from PIL import Image
import numpy as np

##워드클라우드 생성을 위한 패키지

wb = openpyxl.Workbook()

ACCESS_TOKEN = "1545450969022234624-pPIaFUoLP3guAExZLGcxHtydkzhVlC"
ACCESS_SECRET = "YKPFmoW5p2sO51pJ0LMQWy7Ekrlaaz57YrWq4REyp7Iac"
CONSUMER_KEY = "NubWSaPSQ5h223vdmdgRBVR5S"
CONSUMER_SECRET = "HoPnsrSAGaR67t1lAqEGg2ycOFLZaGkf8ysw28jBtBg1X4VSYA"

auth = tweepy.OAuthHandler(CONSUMER_KEY, CONSUMER_SECRET)

auth.set_access_token(ACCESS_TOKEN, ACCESS_SECRET)

api = tweepy.API(auth)

words = []
# keyword=["MZ세대"]
keyword=["개강"]

okt = Okt()

# f = open("MZ워드클라우드.txt","a", encoding='UTF-8')
f = open("개강워드클라우드.txt","a", encoding='UTF-8')

for tweet in api.search_tweets(keyword, count=100):
    nouns = okt.nouns(tweet.text)
    words.append(nouns)

# f.write(str(words))
# f.close()

# r = open("MZ워드클라우드.txt","r",encoding="UTF-8")
r = open("개강워드클라우드.txt","r",encoding="UTF-8")

text = r.read()

# 불용어 처리
okt = Okt()
nouns = okt.nouns(text)
words = [n for n in nouns if len(n) > 1]

print(words)
f.close()


vocab = list(set(w for doc in words for w in doc.split()))
# 정렬하는거임
vocab.sort()

# 총 문서의 수
N = len(words) 

def tf(t, d):
  return d.count(t)

def idf(t):
  df = 0
  for doc in words:
    df += t in doc
  return log(N/(df+1))

def tfidf(t, d):
  return tf(t,d)* idf(t)

result = []

# 각 문서에 대해서 아래 연산을 반복
for i in range(N):
  result.append([])
  d = words[i]
  for j in range(len(vocab)):
    t = vocab[j]
    result[-1].append(tf(t, d))

tf_ = pd.DataFrame(result, columns = vocab)

result = []
for j in range(len(vocab)):
    t = vocab[j]
    result.append(idf(t))

idf_ = pd.DataFrame(result, index=vocab, columns=["IDF"])

result = []
for i in range(N):
  result.append([])
  d = words[i]
  for j in range(len(vocab)):
    t = vocab[j]
    result[-1].append(tfidf(t,d))

tfidf_ = pd.DataFrame(result, columns = vocab)

# x = open("TFIDF(MZ).XLS","a", encoding='utf-8')
# x.write(str(tfidf_))
# x.close()

x = open("TFIDF(개강).XLS","a", encoding='utf-8')
x.write(str(tfidf_))
x.close()



def cos_similarity(v1, v2):
    dot_product = np.dot(v1, v2)
    l2_norm = (np.sqrt(sum(np.square(v1))) * np.sqrt(sum(np.square(v2))))
    similarity = dot_product / l2_norm     
    
    return similarity

cos_words = []

for tweet in api.search_tweets(keyword, count=100):
    # nouns = okt.nouns(tweet.text)
    cos_words.append(tweet.text)

tfidf_vect_simple = TfidfVectorizer()
feature_vect_simple = tfidf_vect_simple.fit_transform(cos_words)



similarity_simple_pair = cosine_similarity(feature_vect_simple , feature_vect_simple)
simpd = pd.DataFrame(feature_vect_simple, feature_vect_simple)

print(similarity_simple_pair)
print()
print("판다스")
print(simpd)

# x = open("코사인유사도(MZ).xls","a", encoding='utf-8')
# x.write(str(similarity_simple_pair))
# x.close()

# x = open("코사인유사도(개강).xls","a", encoding='utf-8')
# x.write(str(similarity_simple_pair))
# x.close()