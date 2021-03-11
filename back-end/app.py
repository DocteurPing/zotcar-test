from flask import Flask, jsonify, request
from flask_sqlalchemy import SQLAlchemy
from datetime import datetime

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///todo.db'
db = SQLAlchemy(app)


class Car(db.Model):  # Modèle
    id = db.Column(db.Integer, primary_key=True)
    brand = db.Column(db.String(50), nullable=True)
    model = db.Column(db.String(50), nullable=True)
    registration = db.Column(db.String(50), nullable=True)
    oil = db.Column(db.String(50), nullable=True)
    seat = db.Column(db.String(50), nullable=True)
    door = db.Column(db.String(50), nullable=True)
    desc = db.Column(db.String(500), nullable=True)
    image = db.Column(db.String(50), nullable=True)
    created_at = db.Column(db.DateTime, nullable=True, default=datetime.now)

    @property
    def serialize(self):
        return {
            'brand': self.brand,
            'model': self.model,
            'registration': self.registration,
            'oil': self.oil,
            'seat': self.seat,
            'door': self.door,
            'desc': self.desc,
            'image': self.image
        }


@app.route("/")
def main():
    return jsonify(data=""), 200


@app.route('/images', methods=['GET'])
def send_cars():
    cars = Car.query.order_by(Car.created_at).all()
    return jsonify(cars=[car.serialize for car in cars])


@app.route('/images', methods=['POST'])
def recieved_cars():
    req_data = request.values
    print(req_data['brand'])
    car = Car(brand=req_data['brand'], model=req_data['model'], registration=req_data['registration'],
              oil=req_data['oil'], seat=req_data['seat'], door=req_data['door'], desc=req_data['desc'], image=req_data['image'])
    db.session.add(car)
    db.session.commit()
    return "OK"


if __name__ == "__main__":
    app.run(host='0.0.0.0')
