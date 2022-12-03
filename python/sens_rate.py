import pandas as pd
import matplotlib.pyplot as plt
from wordcloud import WordCloud
from konlpy.tag import Okt
import re # 정규식을 사용하기 위해 re 모듈을 임포트
'''
import seaborn as sns
import csv
'''
okt = Okt()
'''
train_rdata = pd.read_csv('ratings_test.txt',header = 0, delimiter = '\t', quoting=3)
print("라인 수 ", len(train_rdata))
#print(train_rdata.info())

label = train_rdata['label']

#string외 제거
train_text = [txt for txt in train_rdata['document'] if type(txt) is str]

wordcloud = WordCloud('YGBI08').generate(' '.join(train_text))
plt.imshow(wordcloud, interpolation='bilinear')
plt.axis('off')
plt.show()


###################preprocessing 시간 줄이기 위해 전처리 된 파일 만들기###################
#전처리 후 문자열로 반환 함수 
def preprocessing(org_text, okt, remove_stopwords = False, stop_words =[]):
  #함수인자설명
  # review: 전처리할 텍스트
  # okt: okt객체를 반복적으로 생성하지 않고 미리 생성 후 인자로 받음
  # remove_stopword: 불용어를 제거할지 여부 선택. 기본값 False
  # stop_words: 불용어 사전은 사용자가 직접 입력, 기본값 빈 리스트

  # 1. 한글 및 공백 제외한 문자 모두 제거
  pre_text = re.sub('[^가-힣ㄱ-ㅎㅏ-ㅣ\\s]','',org_text)
  
  #2. okt 객체를 활용하여 형태소 단어로 나눔
  word_pre = okt.morphs(pre_text,stem=True)

  if remove_stopwords:
    #3. 불용어 제거(선택)
    word_pre = [token for token in word_pre if not token in stop_words]
    sent_pre = ' '.join(word_pre)
    #print(sent_pre)
  #sent_pre = sent_pre.strip()
  return sent_pre

# 전체 텍스트 전처리
stop_words = ['은','는','이','가','하','아','것','들','의','있','되','수','보','주','등','한']
prepro_sent  = ['document\tlabel\n']

for idx, e_text in enumerate(train_text):
    prepro_sent.append(preprocessing(e_text,okt,remove_stopwords=True,stop_words= stop_words) + '\t' + str(label[idx]) + '\n')

with open('ratings_prep.txt','w') as file :
    file.writelines(prepro_sent)
###################preprocessing 시간 줄이기 위해 전처리 된 파일 만들기###################
'''

#######실제 감성분석  ##############
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression # 이진 분류 알고리즘
from sklearn.model_selection import GridSearchCV # 하이퍼 파라미터 최적화
import pickle

#train_rdata = pd.read_csv('ratings_prep.txt',header = 0, delimiter = '\t', quoting=3, encoding='CP949')
train_rdata = pd.read_csv('ratings_test.txt',header = 0, delimiter = '\t', quoting=3)
#print("라인 수 ", len(train_rdata))
#print(train_rdata.info())

#train_text = train_rdata['document'] 
train_text =[txt for txt in train_rdata['document'] if type(txt) is str]
label = train_rdata['label']

#wordcloud = WordCloud('YGBI08').generate(' '.join(train_text))
#plt.imshow(wordcloud, interpolation='bilinear')
#plt.axis('off')
#plt.show()

tfv = TfidfVectorizer(tokenizer=okt.morphs, ngram_range=(1,2), min_df=3, max_df=0.9)
tfv.fit(train_text)
'''
pkl_Filename = "senstfv.pkl"
with open(pkl_Filename, 'wb') as file:  
    pickle.dump(tfv, file)
'''
tfv_train_x = tfv.transform(train_text)
#print(tfv_train_x)

clf = LogisticRegression(random_state=0)
params = {'C': [15, 18, 19, 20, 22]}
grid_cv = GridSearchCV(clf, param_grid=params, cv=3, scoring='accuracy', verbose=1)
grid_cv.fit(tfv_train_x, label)

#pkl_Filename = "sensmodel.pkl"
#with open(pkl_Filename, 'wb') as file:  
#    pickle.dump(grid_cv, file)


#with open(pkl_Filename, 'rb') as file:  
#    grid_cv = pickle.load(file)

#print(grid_cv)

#test_text = '딱히 대단한 재미도 감동도 없는데 ~! 너무 과대 평과된 영화 중 하나'
test_text = "재미는 있는데 추천은 안함 "
#입력 텍스트에 대한 전처리 수행
input_text = re.compile(r'[ㄱ-ㅣ가-힣]+').findall(test_text)
input_text = [" ".join(input_text)]
# 입력 텍스트의 피처 벡터화
st_tfidf = tfv.transform(input_text)

# 최적 감성 분석 모델에 적용하여 감성 분석 평가
st_predict = grid_cv.best_estimator_.predict(st_tfidf)

#예측 결과 출력
if(st_predict == 0):
    print('예측 결과: ->> 부정 감성')
else :
    print('예측 결과: ->> 긍정 감성')
