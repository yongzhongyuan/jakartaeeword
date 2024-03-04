# jakartaeeword
get word frequency in the text

count word frequency

Framework: Maven & JakartaEE (OpenLiberty)

Endpoints:
1)Calculate highest frequency:
Example: http://localhost:8080/word/api/check/calculateHighestFrequency?test=test%20the%20highest%20frequency%20word

2)Calculate frequency for word: /calculateFrequencyForWord/{word}/{text}
Example: http://localhost:8080/word/api/check/calculateFrequencyForWord?word=test%20the%20highest%20frequency%20word&text=%20find%20the%20frequent%20word

3)Calculate most frequent words: /calculateMostFrequentNWords/{number}/{text}
Example: http://localhost:8080/word/api/check/calculateMostFrequentNWords?number=2&text=test%20the%20highest%20frequency%20word,%20find%20the%20frequent%20word
