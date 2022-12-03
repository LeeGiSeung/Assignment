from nltk.tokenize import sent_tokenize
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
import tweepy
from konlpy.tag import Okt
from wordcloud import WordCloud
from konlpy.tag import Twitter
from collections import Counter
import matplotlib.pyplot as plt
from PIL import Image
import numpy as np

vocab = {}
preprocessed_sentences = []
stop_words = []

ACCESS_TOKEN = "1545450969022234624-pPIaFUoLP3guAExZLGcxHtydkzhVlC"
ACCESS_SECRET = "YKPFmoW5p2sO51pJ0LMQWy7Ekrlaaz57YrWq4REyp7Iac"
CONSUMER_KEY = "NubWSaPSQ5h223vdmdgRBVR5S"
CONSUMER_SECRET = "HoPnsrSAGaR67t1lAqEGg2ycOFLZaGkf8ysw28jBtBg1X4VSYA"

auth = tweepy.OAuthHandler(CONSUMER_KEY, CONSUMER_SECRET)

auth.set_access_token(ACCESS_TOKEN, ACCESS_SECRET)
words = []
api = tweepy.API(auth)

keyword=["MZ세대"]
# keyword=["개강"]
stop_words = []
okt = Okt()

for tweet in api.search_tweets(keyword, count=100):
    nouns = okt.nouns(tweet.text)
    words = words + nouns


result = []

for word in words: 
    word = word.lower() # 모든 단어를 소문자화하여 단어의 개수를 줄인다.
    print("word"+word)
    if word not in stop_words: # 단어 토큰화 된 결과에 대해서 불용어를 제거한다.
        if len(word) > 2: # 단어 길이가 2이하인 경우에 대하여 추가로 단어를 제거한다.
            result.append(word)
            if word not in vocab:
                vocab[word] = 0 
            vocab[word] += 1
    preprocessed_sentences.append(result) 

c = Counter(vocab)

print(c)

# wc = WordCloud(font_path='malgun', width=400, height=400, scale=2.0, max_font_size=250)
# gen = wc.generate_from_frequencies(c)
# plt.figure()
# plt.imshow(gen)
# wc.to_file('MZ_워드클라우드.png')
# # wc.to_file('개강_워드클라우드.png')