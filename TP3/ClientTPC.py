# exemple internet client TPC
import socket

address = "localhost"
port = 1234

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect((address, port))
print 'Connexion vers ' + address + ':' + str(port) + ' reussie.'

message = input()
print 'Envoi de :' + message
n = client.send(message)
if (n != len(message)):
        print 'Erreur envoi.'
else:
        print 'Envoi ok.'

# supprimer si pas de donnees recues
#print 'Reception...'
#donnees = client.recv(1024)
#print 'Recu :', donnees

print 'Deconnexion.'
client.close()