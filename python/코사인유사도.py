import numpy as np
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
import tweepy
from konlpy.tag import Okt
import pandas as pd
pd.set_option('display.max_seq_items', None)
pd.set_option('display.max_rows', None)
pd.set_option('display.max_columns', None)

def cos_similarity(v1, v2):
    dot_product = np.dot(v1, v2)
    l2_norm = (np.sqrt(sum(np.square(v1))) * np.sqrt(sum(np.square(v2))))
    similarity = dot_product / l2_norm     
    
    return similarity

words = []

ACCESS_TOKEN = "1545450969022234624-pPIaFUoLP3guAExZLGcxHtydkzhVlC"
ACCESS_SECRET = "YKPFmoW5p2sO51pJ0LMQWy7Ekrlaaz57YrWq4REyp7Iac"
CONSUMER_KEY = "NubWSaPSQ5h223vdmdgRBVR5S"
CONSUMER_SECRET = "HoPnsrSAGaR67t1lAqEGg2ycOFLZaGkf8ysw28jBtBg1X4VSYA"

auth = tweepy.OAuthHandler(CONSUMER_KEY, CONSUMER_SECRET)

auth.set_access_token(ACCESS_TOKEN, ACCESS_SECRET)

api = tweepy.API(auth)
words = ""

words = []
keyword=["MZ세대"]
# keyword=["개강"]

okt = Okt()

# f = open("MZ코사인유사도트윗글.xls","a", encoding='UTF-8')
# f = open("개강코사인유사도트윗글.xls","a", encoding='UTF-8')
for tweet in api.search_tweets(keyword, count=100):
    # nouns = okt.nouns(tweet.text)
    words.append(tweet.text)

# f.write(str(words))
# f.close()

tfidf_vect_simple = TfidfVectorizer()
feature_vect_simple = tfidf_vect_simple.fit_transform(words)

# print(feature_vect_simple.shape)
# print(type(feature_vect_simple))

similarity_simple_pair = cosine_similarity(feature_vect_simple , feature_vect_simple)
print(similarity_simple_pair)

# x = open("코사인유사도(MZ).xls","a", encoding='utf-8')
# x.write(str(similarity_simple_pair))
# x.close()

x = open("코사인유사도(개강).xls","a", encoding='utf-8')
x.write(str(similarity_simple_pair))
x.close()