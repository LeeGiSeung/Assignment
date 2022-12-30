import pandas as pd

# area = [2600, 3000, 3200, 3600, 4000]
# price = [550000, 565000, 610000, 680000, 725000]

# df = pd.DataFrame(area, columns = ['document'])

# df['label'] = price

# print(df)

f = open('DC_ratings.txt', 'r', encoding='UTF8')
a = open('DC[영화] 감성분석수치만.txt', 'r', encoding='UTF8')
documents = []
labels = []

for i in range(130120):
    text = f.readline()
    documents.append(text)

for i in range(130120):
    text = a.readline()
    labels.append(text)

df = pd.DataFrame(documents, columns = ['document'])
df['label'] = labels

df.to_csv("DC감성 분석.csv", mode='w')

    # for i in range(130120):
    # line = f.readline()
    # h.append(line)
    # if(st_predict == 0):
    #     a = h[i]
    #     t = "   "
    #     text = str(a) + t + zero
    #     print(text)
    #     # File.write(text+"\n")
    # else :
    #     a = h[i]
    #     t = "   "
    #     text = str(a) + t + one
    #     print(text)