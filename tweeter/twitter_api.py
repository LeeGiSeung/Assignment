from sympy import public
import tweepy
import configparser

# 트위터 api 키
config = configparser.ConfigParser

api_key = "Yr1mp1wcE1YyWFbmLq1xMF4yd"

api_key_secret = "7VqPRbMzxMEIDGw42FKwKF4hzmZNWUkcpia1r5DzhDLk6eu0kg"

Access_Token = "1545450969022234624-9rHKE3Mvg1y9EZf68vLMBpsTvazIcz"
Access_Token_Secret = "aoiJOnEgED9XSSDHY4LFh0xto2XlhCqzuJT9jOU4HHYiW"

Bearer_Token = "AAAAAAAAAAAAAAAAAAAAAAVregEAAAAAEOkAaXEwoNvzJCzN8%2BCdEzA5xco%3DiqbY7nla2uZPCL4JAOCcxclXfg7tN7FeYyDG7B27F0wN2QSC9w"

# 트위터 인증
auth = tweepy.OAuth1UserHandler(api_key, api_key_secret)
auth.set_access_token(Access_Token,Access_Token_Secret)

api = tweepy.API(auth)

#트위터 엑세스 허용이 아직안됨
public_tweets = api.home_timeline()

print(public_tweets)