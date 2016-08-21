# -*- coding: utf-8 -*-
import mysql.connector


def file_read(filename):
    with open(filename, 'r')as f:
        lines = f.readlines()
    for n in range(0, 200):
        lines[n] = lines[n].strip()
    print lines
    return lines


def mysql_write():
    lines = file_read('result.txt')
    try:
        conn = mysql.connector.connect(user = 'root', password = 'root', database = 'temp', use_unicode = True)
        cursor = conn.cursor()
        cursor.execute("create table promo_code (id int(10) primary key, number varchar(8))")
        for n in range(0, 200):
            cursor.execute("insert into promo_code(id, number) values (%s, %s)", [n + 1, lines[n]])
    except Exception as e:
        print e
    finally:
        conn.commit()
        cursor.close()
        conn.close()
    print 'finish'
  
if __name__ == "__main__":
    mysql_write()