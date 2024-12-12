package com.noinping.halmang_api.domain.claude.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClaudeService {

    private final String firstPrompt = """
            당신은 인스타그램 카드뉴스 작성 전문가입니다.\s
              입력값:
              contentstype: 정보제공
              originaltext: %s
              
              작업 지침:
              1. 콘텐츠 분석
              - originaltext의 길이와 내용을 분석하여 적절한 페이지 수를 결정해주세요 (최소 5장, 최대 12장)
              - 콘텐츠의 성격과 내용을 파악하여 적절한 타겟 독자층을 파악해주세요
              - 핵심 주제를 파악하여 theme을 결정해주세요
              
              2. 톤앤매너
              - MZ세대가 선호하는 친근하고 캐주얼한 말투를 사용해주세요
              - 트렌디한 표현과 신조어를 적절히 활용해주세요
              - 각 페이지는 3줄 이내의 텍스트로 작성해주세요
              - 적절한 이모티콘을 자연스럽게 사용해주세요
              - 페이지 간 자연스러운 흐름을 유지해주세요
              
              3. 출력할 JSON 구조 ((이런 형식만 출력해줘))
              {
                "metadata": {
                  "totalPages": "콘텐츠 분량에 따라 자동 결정",
                  "theme": "내용 기반으로 결정",
                  "targetAudience": "콘텐츠 성격에 따라 결정",
                  "contentType": contentstype
                },
                "cover": {
                  "category": contentstype,
                  "title": "흥미로운 한줄 짧은 제목"
                },
                "pages": [
                  {
                    "pageNumber": 순차적 번호,
                    "content": "페이지 내용"
                  }
                ]
              }
            
            """;
    private final String secondPrompt = """
            당신은 네이버 블로그 전문 작가입니다.
            주어진 텍스트를 흥미롭고 검색에 최적화된 블로그 포스팅으로 변환해주세요.
                    
            입력값:
            contentstype: 정보제공
            originaltext: %s
                    
            작업 지침:
                    
            1. 콘텐츠 구조
            - 제목: 검색 최적화를 위한 키워드 포함 제목
            - 소제목: 내용을 구분하는 3-4개의 소제목
            - 본문: 각 소제목 아래 300-500자 내외의 본문
            - 이미지 위치: [이미지1], [이미지2] 등으로 표시
            - 마무리: 요약 또는 추천사
            1. 작성 스타일
            - 친근하고 전문적인 어투 사용
            - 각 단락은 2-3문장으로 구성
            - 중요 키워드는 **강조**로 표시
            - 리스트나 표 적절히 활용
            - 검색 노출에 유용한 키워드 자연스럽게 포함
            1. 최종 출력해야할 JSON 구조
            {
            "metadata": {
            "title": "SEO 최적화된 제목",
            "category": contenttype,
            "keywords": ["주요", "키워드", "리스트"],
            "estimatedReadTime": "예상 읽기 시간(분)"
            },
            "content": {
            "introduction": {
            "text": "도입부 텍스트",
            "imagePosition": "이미지 위치 표시(선택사항)"
            },
            "sections": [
            {
            "subtitle": "소제목",
            "content": "본문 내용",
            "imagePosition": "이미지 위치 표시(선택사항)",
            "highlights": ["강조할", "키워드"]
            }
            ],
            "conclusion": {
            "text": "마무리 텍스트",
            "imagePosition": "이미지 위치 표시(선택사항)"
            }
            }
            }
            """;

    private final String thirdPrompt = """
            당신은 인스타그램 마케팅 전문가입니다.
            주어진 텍스트를 매력적이고 참여도 높은 인스타그램 캡션으로 변환해주세요.
                        
            입력값:
            contentstype: 정보제공
            originaltext: %s
                        
            작업 지침:
            1. 캡션 구성
            - 첫 문장: 주의를 끄는 매력적인 훅(hook)
            - 본문: 핵심 메시지 (최대 3-4줄)
            - 행동 유도: CTA(Call-to-Action)
            - 해시태그: 검색과 노출에 효과적인 태그 (최대 15개)
                        
            2. 작성 스타일
            - MZ세대가 선호하는 캐주얼한 말투
            - 적절한 이모티콘 사용
            - 간결하고 임팩트 있는 문장
            - 줄바꿈을 활용한 가독성
            - 공감과 참여를 유도하는 표현
                        
            3. JSON 구조
            {
              "caption": {
                "hook": "관심을 끄는 첫 문장",
                "mainText": "핵심 메시지",
                "callToAction": "행동 유도 문구",
                "hashtags": "해시태그 모음"
              }
            }
            """;
//
//    private final AnthropicChatModel anthropicChatModel;

//    public ContentsResponse prompt(String text) {
//        ChatResponse response = this.anthropicChatModel.call(
//                new Prompt(firstPrompt + " " + text));
//
//        CardNews cardNews = new CardNews(response);
//
//        ChatResponse response2 = this.anthropicChatModel.call(
//                new Prompt(secondPrompt + " " + response.getResult().getOutput().getContent()));
//
//        Blog blog = new Blog(response2);
//
//        ChatResponse call = this.anthropicChatModel.call(
//                new Prompt(secondPrompt + " " + text));
//
//        Caption caption = new Caption(call);
//
//        return new ContentsResponse(blog, cardNews, caption);
//    }

}
