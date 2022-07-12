import json
import urllib
import requests


def search_by_tag(words):
    url = ('https://www.instagram.com/explore/tags/%s/?__a=1' % (urllib.parse.quote(words)))
    res = requests.get(url).text
    json_data = json.loads(res)

    print("[ Search Tag for %s ]" % words)

    for c, item in enumerate(json_data['graphql']['hashtag']['edge_hashtag_to_media']['edges']):
        if c == 10:
            break

        print("[ %s ]" % str(c+1))
        for content in item['node']['edge_media_to_caption']['edges']:
            
            x = "맛집"
            main_text = content['node']['text']
            if(x in main_text):
                print(main_text)
            else:
                continue
            #print("내용: %s" % content['node']['text'])
        print("짧은 URL: %s" % str('https://www.instagram.com/p/' + item['node']['shortcode']))
        print("사진 URL: %s" % str(item['node']['display_url']))
        print()


def main():
    search_by_tag('영등포역')


if __name__ == '__main__':
    main()