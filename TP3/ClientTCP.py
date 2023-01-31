import socket

address = "localhost"
port = 1234

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect((address, port))
print 'Connexion vers ' + address + ':' + str(port) + ' reussie.'

message = raw_input('Tapez votre message >')
while message.lower().strip() != 'stop':
    client.send(message+"\n".encode())
    message = raw_input(' >')

print 'Deconnexion.'
client.close()
