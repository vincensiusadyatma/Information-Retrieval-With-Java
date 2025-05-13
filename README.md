
# Overview

This is an implementation of an Simple Information Retrieval (IR) system designed to compute document similarity using the Cosine Similarity method based on the TF-IDF model. The system utilizes data structures such as Inverted Index, TF-IDF Matrix, and implements core IR concepts to facilitate text retrieval and analysis.

This project is a university assignment completed during my studies at Sanata Dharma University and focuses on applying basic concepts of information retrieval




## Features

Key Features:

- Inverted Index: Builds an inverted index that stores terms and the documents containing them, allowing fast retrieval.

- TF-IDF Matrix: Computes the TF-IDF weight for each term in the document, which is used to measure the similarity between documents and a given query.

- Cosine Similarity: Measures the similarity between documents using the Cosine Similarity metric, generating similarity scores for each document relative to the query.

- Query Processing: Supports search based on query input, returning ranked results based on similarity scores.

- Term and Document Analysis: Each term is analyzed by calculating the Inverse Document Frequency (IDF) and Term Frequency (TF) to assess the importance of the term in the context of the document.

