package com.gilly.jplanettest

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gilly.jplanettest.data.JPlanetEntity
import com.google.gson.Gson

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.gilly.jplanettest", appContext.packageName)

        var json = "{\n" +
                "    \"minimum_interviews\": 0,\n" +
                "    \"total_page\": 31763,\n" +
                "    \"minimum_reviews\": 0,\n" +
                "    \"total_count\": 317624,\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_COMPANY\",\n" +
                "            \"interview_difficulty\": 2.44,\n" +
                "            \"name\": \"대교(주)\",\n" +
                "            \"salary_avg\": 3483,\n" +
                "            \"web_site\": \"\",\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/production/uploads/company/logo/82465/thumb_25.png\",\n" +
                "            \"interview_question\": \"회사의 이익 규모에 대해 알고 있나?\\r\\n본인이 잘 할 수 있는 분야는?\\r\\n본인은 회사에서 장래 어떤 비전을 갖고 있나?\",\n" +
                "            \"company_id\": 82465,\n" +
                "            \"has_job_posting\": \"true\",\n" +
                "            \"rate_total_avg\": 2.63,\n" +
                "            \"industry_id\": 500,\n" +
                "            \"review_summary\": \"학습지 시장에서 높은 인지도를 가지고 있으나,\\r\\n학습지업 자체가 하락세이며 영업압박이 심함\",\n" +
                "            \"type\": \"INFO\",\n" +
                "            \"industry_name\": \"교육업\",\n" +
                "            \"simple_desc\": \"173 기업리뷰\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_COMPANY\",\n" +
                "            \"interview_difficulty\": 3,\n" +
                "            \"name\": \"바이널아이\",\n" +
                "            \"salary_avg\": 2909,\n" +
                "            \"web_site\": \"\",\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/production/uploads/company/logo/88038/thumb______.jpg\",\n" +
                "            \"interview_question\": \"자기소개, 지원동기, 영어 가능여부, 기존 작업한 문서를 토대로 PT\",\n" +
                "            \"company_id\": 88038,\n" +
                "            \"has_job_posting\": \"false\",\n" +
                "            \"rate_total_avg\": 2.74,\n" +
                "            \"industry_id\": 800,\n" +
                "            \"review_summary\": \"제안, 운영 디바이스 가리지 않고 다양한 업무의 경험과 뒷받침 되는 엄청난 포트폴리오를 쌓을 수 있다. 특히나 뉴미디어 쪽으로의 경험과 커리어를 쌓고 싶다면 강추\",\n" +
                "            \"type\": \"INFO\",\n" +
                "            \"industry_name\": \"미디어/디자인\",\n" +
                "            \"simple_desc\": \"42 기업리뷰\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"count\": 4,\n" +
                "            \"themes\": [\n" +
                "                {\n" +
                "                    \"color\": \"#f78f09\",\n" +
                "                    \"cover_image\": \"https://jpassets.jobplanet.co.kr/production/uploads/job/theme/bg_image/34/thumb_theme_06_03app.png\",\n" +
                "                    \"id\": 34,\n" +
                "                    \"title\": \"월급 도둑. 공범 모집중.\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"color\": \"#b38cee\",\n" +
                "                    \"cover_image\": \"https://jpassets.jobplanet.co.kr/production/uploads/job/theme/bg_image/33/thumb_theme_05_03app.png\",\n" +
                "                    \"id\": 33,\n" +
                "                    \"title\": \"개발이 적성이라면\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"color\": \"#f78f09\",\n" +
                "                    \"cover_image\": \"https://jpassets.jobplanet.co.kr/production/uploads/job/theme/bg_image/21/thumb_App_Startup.jpg\",\n" +
                "                    \"id\": 21,\n" +
                "                    \"title\": \"엄마, 대기업만 답이 아니에요!\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"color\": \"#9dcd72\",\n" +
                "                    \"cover_image\": \"https://jpassets.jobplanet.co.kr/production/uploads/job/theme/bg_image/39/thumb_theme_10_03app.jpg\",\n" +
                "                    \"id\": 39,\n" +
                "                    \"title\": \"이번주 꼭 지원해야 할 회사   \"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"cell_type\": \"CELL_TYPE_HORIZONTAL_THEME\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_COMPANY\",\n" +
                "            \"interview_difficulty\": 2.85,\n" +
                "            \"name\": \"유라코퍼레이션(주)\",\n" +
                "            \"salary_avg\": 4047,\n" +
                "            \"web_site\": \"\",\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/production/uploads/company/logo/60172/thumb___________.png\",\n" +
                "            \"interview_question\": \"1차) 자기소개와 함께 지원하신 동기 말씀해주세요.\\n      와이어링 설계에서 무엇이 중요하다고 생각하나\\n      그외 이력서 특이사항 질문\\n2차) 학교에서 무엇을 배웠나? \\n        또는 학교에서 무엇을 하였는가?\\n        \",\n" +
                "            \"company_id\": 60172,\n" +
                "            \"has_job_posting\": \"false\",\n" +
                "            \"rate_total_avg\": 2.77,\n" +
                "            \"industry_id\": 200,\n" +
                "            \"review_summary\": \"글로벌한 근무환경과 다양한 직무경험 보수적인 분위기\",\n" +
                "            \"type\": \"INFO\",\n" +
                "            \"industry_name\": \"제조/화학\",\n" +
                "            \"simple_desc\": \"149 기업리뷰\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_COMPANY\",\n" +
                "            \"interview_difficulty\": 2.25,\n" +
                "            \"name\": \"젬스메디컬(주)\",\n" +
                "            \"salary_avg\": 3067,\n" +
                "            \"web_site\": \"\",\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/production/uploads/company/logo/56099/thumb_56099.JPG\",\n" +
                "            \"interview_question\": \"1. 업무 관련 지식에 대한 질문\\r\\n2. 협업과 관련된 사람들을 대하는 태도 질문\\r\\n3. 할 수 있는 일과 하고 싶은 일\\r\\n4. 본인의 장단점에 관한 질문\",\n" +
                "            \"company_id\": 56099,\n" +
                "            \"has_job_posting\": \"false\",\n" +
                "            \"rate_total_avg\": 2.38,\n" +
                "            \"industry_id\": 200,\n" +
                "            \"review_summary\": \"개발/연구 등 많은 투자를 통해서 DR시스템업체로 발돋움을 하려고 하였으나 경영진의 이원화 및 집중화 부족으로 예측할 수 없는 상황\",\n" +
                "            \"type\": \"INFO\",\n" +
                "            \"industry_name\": \"제조/화학\",\n" +
                "            \"simple_desc\": \"13 기업리뷰\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_REVIEW\",\n" +
                "            \"cons\": \"지사로써의 한계. 모든 결정 및 책임은 본사로부터 나옴. 너무 비용만을 고려한 의사결정은 회사에 대한 충성도를 떨어 뜨림\",\n" +
                "            \"name\": \"퀄컴씨디엠에이테크날러지코리아(유)\",\n" +
                "            \"days_ago\": 311,\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/production/uploads/company/logo/6991/thumb_____35.PNG\",\n" +
                "            \"pros\": \"매니저의 눈치를 거의 안보고 업무만 집중할 수 있는 분위기. 높은 수준의 연봉. 업계 최고의 기술력을 보유하고 있음. 체계화된 프로세스등 배울 것이 많음. 해외의 유능한 엔지니어와의 소통을 통해 느끼고 배울수 있는 기회\",\n" +
                "            \"company_id\": 6991,\n" +
                "            \"occupation_name\": \"IT/인터넷\",\n" +
                "            \"rate_total_avg\": 4.25,\n" +
                "            \"industry_id\": 400,\n" +
                "            \"date\": \"2015-10-24T21:17:50.000+09:00\",\n" +
                "            \"review_summary\": \"자기가 한만큼 인정 받고 대접을 받을 수 있는 곳\",\n" +
                "            \"type\": \"REVIEW\",\n" +
                "            \"industry_name\": \"유통/무역/운송\",\n" +
                "            \"simple_desc\": \"12 기업리뷰\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_COMPANY\",\n" +
                "            \"interview_difficulty\": 3.25,\n" +
                "            \"name\": \"한국원자력의학원\",\n" +
                "            \"salary_avg\": 3209,\n" +
                "            \"web_site\": \"\",\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/production/uploads/company/logo/3247/thumb_________.png\",\n" +
                "            \"interview_question\": \"지원하는 직무에 본인이 적합한 이유를 설명하시오.\\n지원하는 직무가 하는일을 설명하시오.\",\n" +
                "            \"company_id\": 3247,\n" +
                "            \"has_job_posting\": \"true\",\n" +
                "            \"rate_total_avg\": 3,\n" +
                "            \"industry_id\": 1000,\n" +
                "            \"review_summary\": \"교통이 괜찮고 넉넉한 근무, 하지만 챗바퀴 도는 기분\",\n" +
                "            \"type\": \"INFO\",\n" +
                "            \"industry_name\": \"기관/협회\",\n" +
                "            \"simple_desc\": \"25 기업리뷰\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_COMPANY\",\n" +
                "            \"interview_difficulty\": 3.24,\n" +
                "            \"name\": \"가비아(주)\",\n" +
                "            \"salary_avg\": 3357,\n" +
                "            \"web_site\": \"\",\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/production/uploads/company/logo/86149/thumb____.png\",\n" +
                "            \"interview_question\": \"고객이 홈페이지를 제작하고 싶어한다. 어떻게 응대를 하겠느냐 \",\n" +
                "            \"company_id\": 86149,\n" +
                "            \"has_job_posting\": \"true\",\n" +
                "            \"rate_total_avg\": 3.41,\n" +
                "            \"industry_id\": 700,\n" +
                "            \"review_summary\": \"매너리즘 심각함, 부서에 따라서 업무량과 부담이 확 다름.\",\n" +
                "            \"type\": \"INFO\",\n" +
                "            \"industry_name\": \"IT/웹/통신\",\n" +
                "            \"simple_desc\": \"74 기업리뷰\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_REVIEW\",\n" +
                "            \"cons\": \"고객의 니즈에 맞춰 제품 제작이 이루어져 관련 기술응용 함에 좋으나 표준 제품 제작보다 시간이 좀 더 투입됨.\",\n" +
                "            \"name\": \"한미반도체(주)\",\n" +
                "            \"days_ago\": 721,\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/production/uploads/company/logo/2679/thumb_2679.png\",\n" +
                "            \"pros\": \"반도체 관련 산업 전망에 대해 이해할 수 있으며 이름도 알려져 있어 커리어 관리하기에는 좋음.\",\n" +
                "            \"company_id\": 2679,\n" +
                "            \"occupation_name\": \"경영/기획/컨설팅\",\n" +
                "            \"rate_total_avg\": 2.37,\n" +
                "            \"industry_id\": 200,\n" +
                "            \"date\": \"2014-09-09T18:04:31.000+09:00\",\n" +
                "            \"review_summary\": \"반도체 후공정 장비 1위 인지도는 있음\",\n" +
                "            \"type\": \"REVIEW\",\n" +
                "            \"industry_name\": \"제조/화학\",\n" +
                "            \"simple_desc\": \"49 기업리뷰\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_COMPANY\",\n" +
                "            \"interview_difficulty\": 2.91,\n" +
                "            \"name\": \"위메프(주)\",\n" +
                "            \"salary_avg\": 2828,\n" +
                "            \"web_site\": \"\",\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/production/uploads/company/logo/60632/thumb_______.png\",\n" +
                "            \"interview_question\": \"1. 전 직장에서 했던 일\\r\\n2. 위메프에 입사하려는 이유\\r\\n3. 성취한 일, 실패한 일. 교훈\",\n" +
                "            \"company_id\": 60632,\n" +
                "            \"has_job_posting\": \"true\",\n" +
                "            \"rate_total_avg\": 2.53,\n" +
                "            \"industry_id\": 400,\n" +
                "            \"review_summary\": \"AMD도 MD가 될 수 있는 기회가 열린 곳. 열정을 높이 사는 곳, 신입 분들에게 권합니다. 매우 빠르게 성장하면서 성장통을 겪고 있는 회사. 과도한 업무, 체계 부족이 문제이지만 문제 개선을 위해 노력하는 회사.\",\n" +
                "            \"type\": \"INFO\",\n" +
                "            \"industry_name\": \"유통/무역/운송\",\n" +
                "            \"simple_desc\": \"325 기업리뷰\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_COMPANY\",\n" +
                "            \"interview_difficulty\": 2.33,\n" +
                "            \"name\": \"미래디자인아이엠씨(주)\",\n" +
                "            \"salary_avg\": 0,\n" +
                "            \"web_site\": \"\",\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/assets/default_logo_share-12e4cb8f87fe87d4c2316feb4cb33f42d7f7584f2548350d6a42e47688a00bd0.png\",\n" +
                "            \"interview_question\": \"전에 직장에서 무슨업무를 했었는가 연봉은 얼마정도 생각하는가 압박질문은 없었다. 부모님께서 무슨 일하시나 물어보시며 비웃으셨다......\",\n" +
                "            \"company_id\": 311583,\n" +
                "            \"has_job_posting\": \"false\",\n" +
                "            \"rate_total_avg\": 0,\n" +
                "            \"industry_id\": 800,\n" +
                "            \"review_summary\": \"\",\n" +
                "            \"type\": \"INFO\",\n" +
                "            \"industry_name\": \"미디어/디자인\",\n" +
                "            \"simple_desc\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_REVIEW\",\n" +
                "            \"cons\": \"명절 상여금x. 소프트크림및 치킨을 팔아서 관리하는데 손이 자주감 . 승진하려면 일본어 잘해야되서 이직률도 높은듯\",\n" +
                "            \"name\": \"한국미니스톱(주)\",\n" +
                "            \"days_ago\": 261,\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/production/uploads/company/logo/3585/thumb_3585.png\",\n" +
                "            \"pros\": \"돈은 많이주는편. 초봉이 세금띠고 3250정도 되는듯. 6개월 점장생활을 거친뒤, 15개 매장을 관리한다. 편의점 숫자는 전국4등이지만 점포당 매출액은 1위\",\n" +
                "            \"company_id\": 3585,\n" +
                "            \"occupation_name\": \"영업/제휴\",\n" +
                "            \"rate_total_avg\": 2.52,\n" +
                "            \"industry_id\": 400,\n" +
                "            \"date\": \"2015-12-14T00:23:23.000+09:00\",\n" +
                "            \"review_summary\": \"전형적인 일본식회사. 한국 특유의 매출압박은 없으나,상여금 및 명절떡값도 없음 (개인주의가 심해서 특유의  소속감 부재)\",\n" +
                "            \"type\": \"REVIEW\",\n" +
                "            \"industry_name\": \"유통/무역/운송\",\n" +
                "            \"simple_desc\": \"125 기업리뷰\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"count\": 3,\n" +
                "            \"themes\": [\n" +
                "                {\n" +
                "                    \"color\": \"#ff9f97\",\n" +
                "                    \"cover_image\": \"https://jpassets-staging.jobplanet.co.kr/staging/uploads/job/theme/bg_image/41/thumb_theme_12_03app.jpg\",\n" +
                "                    \"id\": 41,\n" +
                "                    \"title\": \"은행. 불확실성과의 싸움.  \"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"color\": \"#9dcd72\",\n" +
                "                    \"cover_image\": \"https://jpassets-staging.jobplanet.co.kr/staging/uploads/job/theme/bg_image/32/thumb_theme_04_03app.png\",\n" +
                "                    \"id\": 32,\n" +
                "                    \"title\": \"찾습니다. 신입을.\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"color\": \"#9dcd72\",\n" +
                "                    \"cover_image\": \"https://jpassets-staging.jobplanet.co.kr/staging/uploads/job/theme/bg_image/39/thumb_theme_10_03app.jpg\",\n" +
                "                    \"id\": 39,\n" +
                "                    \"title\": \"이번주 꼭 지원해야 할 회사   \"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"color\": \"#ff9f97\",\n" +
                "                    \"cover_image\": \"https://jpassets-staging.jobplanet.co.kr/staging/uploads/job/theme/bg_image/41/thumb_theme_12_03app.jpg\",\n" +
                "                    \"id\": 41,\n" +
                "                    \"title\": \"은행. 불확실성과의 싸움.  \"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"color\": \"#9dcd72\",\n" +
                "                    \"cover_image\": \"https://jpassets-staging.jobplanet.co.kr/staging/uploads/job/theme/bg_image/32/thumb_theme_04_03app.png\",\n" +
                "                    \"id\": 32,\n" +
                "                    \"title\": \"찾습니다. 신입을.\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"cell_type\": \"CELL_TYPE_HORIZONTAL_THEME\",\n" +
                "            \"smb\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"ranking\": 1,\n" +
                "            \"cell_type\": \"CELL_TYPE_COMPANY\",\n" +
                "            \"interview_difficulty\": 3,\n" +
                "            \"name\": \"시내엔들(주)\",\n" +
                "            \"salary_avg\": 0,\n" +
                "            \"web_site\": \"\",\n" +
                "            \"logo_path\": \"https://jpassets.jobplanet.co.kr/assets/default_logo_share-12e4cb8f87fe87d4c2316feb4cb33f42d7f7584f2548350d6a42e47688a00bd0.png\",\n" +
                "            \"interview_question\": \"편안한 분위기에서 불편한 질문들, 사적인 질문 많음. 압박면접이라 생각하면 괜찮으나 개인적으로 불편했음. 나중엔 속으로 '에라 모르겠다 나 뽑든말든 맘대로해라'라는 심보가 자라남. \",\n" +
                "            \"company_id\": 70508,\n" +
                "            \"has_job_posting\": \"false\",\n" +
                "            \"rate_total_avg\": 0,\n" +
                "            \"industry_id\": 400,\n" +
                "            \"review_summary\": \"\",\n" +
                "            \"type\": \"INFO\",\n" +
                "            \"industry_name\": \"유통/무역/운송\",\n" +
                "            \"simple_desc\": \"\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"page\": 1,\n" +
                "    \"page_size\": 10,\n" +
                "    \"minimum_salaries\": 0\n" +
                "}"

        val a = Gson().fromJson(json, JPlanetEntity::class.java)

    }
}