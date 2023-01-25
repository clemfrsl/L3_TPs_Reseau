
import socket, sys, threading

class ThreadReception(threading.Thread):
  def __init__(self, connexion):
      threading.Thread.__init__(self)
      self.connexion = connexion
 
  def run(self):
      while 1:
          message_recu = self.connexion.recv(1024).decode("Utf8")
          print("*" + message_recu + "*")
          if not message_recu or message_recu.upper() =="FIN":
              break
          th_E._stop()
          print("Client arrêté. Connexion interrompue.")
          self.connexion.close()
 
class ThreadEmission(threading.Thread):
  """objet thread gérant l'émission des messages"""
  def __init__(self, connexion):
      threading.Thread.__init__(self)
      self.connexion = connexion	     # réf. du socket de connexion
 
  def run(self):
      while 1:
          message_emis = input()
          self.connexion.send(message_emis.encode("Utf8"))
          

address = "localhost"
port = 1234

connexion = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
try:
  connexion.connect((address, port))
except socket.error:
  print("La connexion a échoué.")
  sys.exit()
print("Connexion établie avec le serveur.")
 
th_E = ThreadEmission(connexion)
th_R = ThreadReception(connexion)
th_E.start()
th_R.start()
