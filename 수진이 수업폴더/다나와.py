from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import numpy as np
# 사용에 아무런 의미가 없음 걍 쓴거임.
import undetected_chromedriver as uc

a = np.array

# 대기 시간 1초
LOADING_WAIT_TIME= 10
# 크롤링할 상품 코드
pcodes = ['14142050']
# 결과 리스트
result = []

def init_driver():
    driver = uc.Chrome(use_subprocess=True)
    return driver


def find_review(pcode, driver):
    url = f'http://prod.danawa.com/info/?pcode={pcode}'
    driver.get(url)
    # 제휴 쇼핑몰 리뷰 클릭
    WebDriverWait(driver, LOADING_WAIT_TIME).until(
        EC.presence_of_element_located(
            (By.XPATH,'//*[@id="danawa-prodBlog-productOpinion-button-tab-companyReview"]')
        )
    )

    
    driver.find_element(By.XPATH,'//*[@id="danawa-prodBlog-productOpinion-button-tab-companyReview"]').click()

    for i in range(1, 1000):
        # 이번 페이지의 모든 리뷰가 로드 될때까지 기다림
        WebDriverWait(driver, LOADING_WAIT_TIME).until(
            EC.visibility_of_all_elements_located(
                (By.CLASS_NAME,'atc')
            )
        )
        for review in driver.find_elements(By.CLASS_NAME,'atc'):
            result.append(review.text)

        
        if i % 10 == 0:
            # 10개를 다 봤다면 다음 10개를 보는 버튼 클릭, 만약 클릭이 안되면 종료
            right_btn = driver.find_element(By.XPATH, '//*[@class="mall_review"]//span[@class="point_arw_r"]')
            if right_btn.value_of_css_property('cursor') == 'pointer':
                right_btn.click()
            else:
                break
        else:
            try: # 다음 페이지가 없을 경우
                WebDriverWait(driver, LOADING_WAIT_TIME).until(
                        EC.presence_of_element_located(
                            (By.XPATH, f'//*[@id="danawa-prodBlog-companyReview-content-list"]/div/div/div/a[text()={i + 1}]')
                        )
                    )
            except:
                break
            driver.find_element(By.XPATH, f'//*[@id="danawa-prodBlog-companyReview-content-list"]/div/div/div/a[text()={i + 1}]').click()
if __name__ == "__main__":
    driver = init_driver()
    for pcode in pcodes:
        find_review(pcode, driver)
    print(len(result))
    for r in result:
        print(r)