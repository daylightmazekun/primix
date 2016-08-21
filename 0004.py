# -*- coding: utf-8 -*-  
import re


def counter(string):
    words = re.findall(r'[a-zA-Z]+(\'[a-zA-z]+|\b)', string)
    amount = len(words)
    return str(amount)
def file_read(filename):
    with open(filename, 'r') as fp:
        article = fp.read()
        return article

if __name__ == "__main__":
    string = file_read("Github.txt")
    result = counter(string)
    print 'There are', result, 'words in this article.'
    print '这篇文章有' + result + '个英文单词'
    
    
    
    
    
    