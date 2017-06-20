# -*- coding: UTF-8 -*-

class Clube:
    def __init__(self, nome):
        self.nome = nome
        self.medias = []

    def add_media(self, ano, media):
        self.medias.append((ano, media))

    def count(self):
        return len(self.medias)

    def as_tuple(self):
        return (self.nome, self.count())

def main():
    clubes = {}
    linhas = [line.rstrip('\n').split(' ') for line in open('medias.txt')]

    for linha in linhas:
        nome_clube = linha[1]
        if nome_clube != 'Não' and nome_clube not in clubes:
            clubes[nome_clube] = Clube(nome_clube)
        media = linha[2].replace('.', '')

        if media.isdigit():
            clubes[nome_clube].add_media(linha[0][:-1], int(media))

    l = [clube[1].as_tuple() for clube in clubes.items()]
    ordenado_por_media = sorted(l, key=lambda tup: -tup[1])

    for clube_media in ordenado_por_media:
        print clube_media[0] + ' > ' + str(clube_media[1])


if __name__ == "__main__":
    main()
