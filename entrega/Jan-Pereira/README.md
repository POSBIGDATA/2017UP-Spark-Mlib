# Spark / Scala

### Autor

  - [Jan Antonio Pereira]

### Artigo

O artigo escolhido por mim para ser traduzido foi Spark-Basic-Statistics-RDD-based-API.

Obs: O artigo original encontra-se em http://spark.apache.org/docs/latest/mllib-statistics.html e a respectiva tradução pode ser encontrada na pasta artigo.

### Problema

Dado um conjunto de livros dividos em diversos capítulos em formato HTML, conforme disponibilizado na pasta lit2go.

1) Extrair apenas os textos de cada capítulo e produzir um arquivo único em formato .txt contendo todo o livro com todas as palavras em caixa-baixa, salvando estes livros na pasta fullbooks. O resultado do processamento com os arquivos da pasta fullbooks foram disponibilizados em formato zip.

2) Remover as preposições e outras classes de palavras menos significantes dos livros da pasta fullbooks e salvar em wordsbooks. O resultado do processamento com os arquivos da pasta wordsbooks foram disponibilizados em formato zip.

3) Mover a pasta wordsbooks e fullbooks com os arquivos txts gerados para o HDFS. 

3) Fornecer uma palavra e mostrar em que arquivos encontramos a palavra usando Spark e Scala.

4) Fornecer uma palavra e mostrar em que arquivos encontramos a palavra e a quantidade de ocorrências usando Spark e Scala.

### Requisitos

  - Como ambiente de desenvolvimento foi baixado o VirtualBox e uma imagem da VM do cloudera.
  - A VM cloudera já nos entrega instalado o básico que precisamos como Python 2.7, Spark, Scala e muitos outros softwares.
  - Para extrair os textos dos arquivos HTMLs foi instalada a biblioteca BeautifulSoup (bs4).
  - Para extrair as preposições dos textos foi instalada a biblioteca NLTK.
  - Para procurar e contar palavras dentro dos arquivos textos utilizamos a linguagem Scala.
  - Para processar os dados usamos Spark.
  
### Solução

Para a executação dos scripts abaixo, utilize o terminal disponível na VM cloudera.

1) Para extrair e gerar os textos em formato txt de cada capítulo para cada livro, execute o script abaixo:
python extract_text.py <input_path_book_html> <output_path_book_txt>

ex:  python extract_text.py /home/janpereira/books /home/janpereira/books/fullbooks

Obs: Certifique-se que o diretório de destino exista de executar o extract_text.py. 

2) Para extrair e gerar os textos em formato txt removendo as preposições e outras classes de palavras, execute o script abaixo: 

python remove_class_words.py <input_path_book_txt> <output_path_book_txt>

ex: python remove_class_words.py /home/janpereira/books/fullbook /home/janpereira/books/wordsbooks

Obs: 
Lembre-se de instalar a biblioteca python NLTK.
Para analisar as classes de palavras será importante fazer o download dos datasets da linguagem inglesa.
Após instalar a biblioteca NLTK, para auxiliá-lo no download dos datasets basta executar python download_nltk.py.
Agora sim, basta se certificar que o diretório de destino exista e executar o remove_class_words.py.

3) Para mover a pasta books para o HDFS, execute o script abaixo:

hdfs dfs -put <path_local_book> <path_hdfs_book>

3) Para procurar e listar os livros que contenham uma dada palavra, execute o script abaixo:

//Editar o arquivo SearchWordFile.scala para informar o local onde encontra-se os livros e a palavra a ser buscada.

spark-shell -i SearchWordFile.scala

4) Para procurar, listar e contar os livros que contenham uma dada palavra, execute o script abaixo:

//Editar o arquivo SearchWordCountFile.scala para informar o local onde encontra-se os livros e a palavra a ser buscada.

spark-shell -i SearchWordCountFile.scala


