try:
    import os
    from requests_html import HTMLSession
    from clint.textui import progress
    import requests
except:
    import os
    os.system("pip install requests-html")
    os.system("pip install clint")
    os.system("pip install requests")


#test
    

session = HTMLSession()
anime_dicari = input("masukkan nama anime : ")
link_anime = []
link_video =[]

folders=''
for i in __file__.split("\\")[0:len(__file__.split("\\"))-1]:
    folders = folders+i+'/'


html_get = session.get(f'https://kuramanime.pro/anime?order_by=latest&search={anime_dicari}&page=1')
for i in html_get.html.xpath('/html/body/section/div/div/div/div/div/div/div/div/h5/a'):
    link_anime.append(i.attrs['href'])


print(f'di temukan {len(link_anime)} anime dengan keyword {anime_dicari}')
for ik in range(len(link_anime)):
    print(f"{ik+1}. {((link_anime[ik].split('/'))[5]).replace('-',' ')}")

pilihan_anime = input("ingin mendownload yang mana : ")
pilihan_download = input("apakah anda ingin langsung mendowload semuanya (Y/n) : ")
masih_dibatas = True    
proses_download = True
episode =1
session = HTMLSession()
if(not (os.path.exists(f"{folders}video"))):
    os.mkdir(f"{folders}video")
while (masih_dibatas):
    proses_download = True
    while (proses_download):
        if (os.path.exists(f"{folders}video/{((link_anime[int(pilihan_anime)-1].split('/'))[5]).replace('-',' ')} {episode}.mp4")):
            print(f"terskip bang si {((link_anime[int(pilihan_anime)-1].split('/'))[5]).replace('-',' ')} {episode}")
            break
        ok = session.get(link_anime[int(pilihan_anime)-1]+f'/episode/{episode}')
        # print(ok)
        if(ok.status_code == 404):
            print(f"kamu tersesat bang katanya, ga bisa deh download {((link_anime[int(pilihan_anime)-1].split('/'))[5]).replace('-',' ')} eps {episode}")
            masih_dibatas = False
            break
        
        
        elif (ok.status_code == 200):
            ok.html.render(sleep=1, keep_page=False, scrolldown =1, timeout=20)
            videos = ok.html.find('source')
            for il in videos:
                if (il.attrs['size'] == '720'):
                    link_video.append(il.attrs['src'])
                    if(pilihan_download.upper() == 'Y'):
                        print(f"sedang mendownload {((link_anime[int(pilihan_anime)-1].split('/'))[5]).replace('-',' ')} eps {episode} bang")
                        responsec = requests.get(il.attrs['src'], stream=True)
                        if(responsec.status_code != 200):
                            print('gagal download, sedang mencoba lagi')
                            break
                            
                        with open(f"{folders}video/{((link_anime[int(pilihan_anime)-1].split('/'))[5]).replace('-',' ')} {episode}.mp4", 'wb') as f:
                            total_length = int(responsec.headers.get('content-length'))
                            for chunk in progress.bar(responsec.iter_content(chunk_size=1024), expected_size=(total_length/1024) + 1): 
                                if chunk:
                                    f.write(chunk)
                                    f.flush()
                        print()
                    else:
                        print(f'sedang mendapatkan link download nomor {episode}')
                    proses_download = False
    episode = episode+1
    


print('\n\n\n\n\n')
print(f"berikut link untuk mendownload anime {((link_anime[int(pilihan_anime)-1].split('/'))[5]).replace('-',' ')}")
for i in range(len(link_video)):
    print(f'{i+1}. {link_video[i]}')
                    
