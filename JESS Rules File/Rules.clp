(deftemplate probelm
    (multislot name)
    (slot symptom))

    (deffacts probelms
(probelm (name (create$ Low Battery-Charge car Battery,Carbon on battery Terminals-Clean Terminal With Warm Water,Timing Belt-Tighten Car Engine Belt)) 
        (symptom hard-start))
        )


(deffacts probelms
(probelm (name (create$ Faulty Spark Plug or Wires-Replace plug or clean it if Cleanable,Dirty Fuel injector-Refer Mechanic,Cylinder valve leak-Refer Mechanic)) 
        (symptom engine-missfire))
        )

(deffacts probelms
(probelm (name (create$ Tapet Not Adjusted Properly-Refer Mechanic,Faulty Spark Plug-Replace plug or clean it if Cleanable,Air filter Chowk-Clean or Replace Air filter,Fuel Injector Leakage-Refer Mechanic,Bad engine oil-Change Engine Oil,Low Air Pressure in Tyres-Check Pressure in Tyres,Weak clutch plates-Refer Mechanic)) 
        (symptom high-fuel-consumption))
        )


(deffacts probelms
(probelm (name (create$ Low Fuel pump Pressure-Refer Mechanic,Weak Clutch Plates-Refer Mechanic,Weak Engine/Ring Pistons-Refer Mechanic)) 
        (symptom lack-of-acceleration))
        )



(deffacts probelms
(probelm (name (create$ Dry belt-Grease the Belt,Miss alignment of the Belt-Correct the Alignmen,No proper tension in belt-Change Belt)) 
        (symptom squeaky-belt-noise))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve)) 
        (symptom blue-smoke))
        )





(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve)) 
        (symptom white-smoke))
        )


(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic)) 
        (symptom black-smoke))
        )



(deffacts probelms
(probelm (name (create$ Problem in Transmission Fliud-Refer Mechanic,Bad Turbo Charger-Refer Mechanic)) 
        (symptom grey-smoke))
        )



(deffacts probelms
(probelm (name (create$ Fan might not be Working-Refer Mechanic,Coolant level Low-Insert Coolant,Water body Belt problem-Refer Mechanic,Radiator pipe leakage-Refer Mechanic,Head Gas kit Half assembly-Refer Mechanic)) 
        (symptom overheating-engine))
        )


(deffacts probelms
(probelm (name (create$ Coolant level Low-Insert Coolant,Cooling System Leakage-Refer Mechanic,Fan might not be Working 'Over Heating Engine'-Refer Mechanic)) 
        (symptom jerking-car))
        )

(deffacts probelms
(probelm (name (create$ Bad clutch Plates might be burning-Refer Mechanic,Car Tyres'Running long time' smells burning-Give a Rest to the Car,Driving belt might be slipping or loose-Refer Mechanic)) 
        (symptom burning-rubber))
        )




(deffacts probelms
(probelm (name (create$ Need Oil Engine Oil-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom burning-oil))
        )

(deffacts probelms
(probelm (name (create$ Fuel Tank Leak-Refer Mechanic,Fuel Line Leak-Refer Mechanic)) 
        (symptom gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom burning-carpet))
        )



(deffacts probelms
(probelm (name (create$ Bad clutch Plates might be burning-Refer Mechanic,Need Oil Engine Oil-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom burning-oil-and-burning-rubber))
        )

(deffacts probelms
(probelm (name (create$ Bad clutch Plates might be burning-Refer Mechanic,Fuel Tank Leak-Refer Mechanic,Fuel Supply Line Leak-Refer Mechanic)) 
        (symptom burning-rubber-and-gasoline-smell))
        )



(deffacts probelms
(probelm (name (create$ Bad clutch Plates might be burning-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom burning-carpet-and-burning-rubber))
        )

(deffacts probelms
(probelm (name (create$ Need Oil Engine Oil-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Fuel Tank Leak-Refer Mechanic,Fuel Line Leak-Refer Mechanic)) 
        (symptom burning-oil-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Need Oil Engine Oil-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom burning-carpet-and-burning-oil))
        )

(deffacts probelms
(probelm (name (create$ Fuel Tank Leak-Refer Mechanic,Fuel supply Line Leak-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom burning-carpet-and-gasoline-smell))
        )


(deffacts probelms
(probelm (name (create$ Bad clutch Plates might be burning-Refer Mechanic,Need Engine Oil Change-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Fuel Tank Leak-Refer Mechanic,Fuel supply Line Leak-Refer Mechanic)) 
        (symptom burning-oil-and-burning-rubber-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Bad clutch Plates might be burning-Refer Mechanic,Need Engine Oil Change-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom burning-carpet-and-burning-oil-and-burning-rubber))
        )

(deffacts probelms
(probelm (name (create$ Fuel Tank Leak-Refer Mechanic,Fuel supply Line Leak-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap,Need Oil Engine Oil-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom burning-carpet-and-burning-oil-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Fuel Leakage-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap,Need Engine Oil Change-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,Driving belt might be slipping or loose-Refer Mechanic)) 
        (symptom burning-carpet-and-burning-oil-and-burning-rubber-and-gasoline-smell))
        )


(deffacts probelms
(probelm (name (create$ Gear lever Problem-Refer Machanic,Gear saikromiser-Refer Mechanic,Clucth Plates might not be in good Condition-Refer Mechanic)) 
        (symptom gear-slipping))
        )


(deffacts probelms
(probelm (name (create$ Faulty Spark Plug-Replace plug or clean it if Cleanable,Low Air Pressure in Tyres-Check Air Pressure in Tyres,Dirty Fuel injector-Refer Mechanic,Bad engine oil-Change Engine Oil)) 
        (symptom engine-missfire-and-high-fuel-consumption))
        )

(deffacts probelms
(probelm (name (create$ Battery Problem-Check car Battery and Terminals,Timing Belt-Tighten Car Engine Belt,Tapet Not Adjusted Properly-Refer Mechanic,Faulty Spark Plug-Replace plug or clean it if Cleanable,Air filter Chowk-Clean or Replace Air filter,Fuel Injector Leakage-Refer Mechanic,Low Air Pressure in Tyres-Check Pressure in Tyres)) 
        (symptom hard-start-and-high-fuel-consumption))
        )

(deffacts probelms
(probelm (name (create$ Battery Problem-Check car Battery and Terminals,Timing Belt-Tighten Car Engine Belt,Coolant level Low-Insert Coolant,Cooling System Leakage-Refer Mechanic,Fan might not be Working 'Over Heating Engine'-Refer Mechanic)) 
        (symptom hard-start-and-jerking-car))
        )

(deffacts probelms
(probelm (name (create$ Battery Problem-Check car Battery and Terminals,Tapet Not Adjusted Properly-Refer Mechanic,Coolant level Low-Insert Coolant,Cooling System Leakage-Refer Mechanic,Fan might not be Working 'Over Heating Engine'-Refer Mechanic)) 
        (symptom hard-start-and-high-fuel-consumption-and-jerking-car))
        )

(deffacts probelms
(probelm (name (create$ Faulty Spark Plug-Replace plug or clean it if Cleanable,Low Battery-Charge car Battery,Fuel Injector Leakage-Refer Mechanic,Fan might not be Working Over Heating Engine-Check Fan or Refer Mechanic,Clucth Plates might not be in good Condition-Refer Mechanic)) 
        (symptom hard-start-and-high-fuel-consumption-and-jerking-car-and-gear-slipping))
        )


(deffacts probelms
(probelm (name (create$ Faulty Spark Plug-Replace plug or clean it if Cleanable,Low Battery-Charge car Battery,Clucth Plates might not be in good Condition-Refer Mechanic)) 
        (symptom hard-start-and-gear-slipping))
        )

(deffacts probelms
(probelm (name (create$ Faulty Spark Plug-Replace plug or clean it if Cleanable)) 
        (symptom high-fuel-consumption-and-jerking-car))
        )


(deffacts probelms
(probelm (name (create$ Faulty Spark Plug-Replace plug or clean it if Cleanable,Fuel Injector Leakage-Refer Mechanic,Bad engine oil-Change Engine Oil)) 
        (symptom engine-missfire-and-lack-of-acceleration))
        )




(deffacts probelms
(probelm (name (create$ Faulty Spark Plug-Replace plug or clean it if Cleanable,Dirty Fuel injector-Refer Mechanic)) 
        (symptom engine-missfire-and-overheating-engine))
        )


(deffacts probelms
(probelm (name (create$ Faulty Spark Plug-Replace plug or clean it if Cleanable,Coolant level Low-Insert Coolant,Cooling System Leakage-Refer Mechanic,Fan might not be Working-Refer Mechanic,Leaky Head Gasket-Refer Mechanic)) 
        (symptom lack-of-acceleration-and-overheating-engine))
	)



(deffacts probelms
(probelm (name (create$ Dirty Fuel injector-Refer Mechanic,Faulty Spark Plug-Replace plug or clean it if Cleanable,Bad Timing belt-Change Belt,Coolant level Low-Insert Coolant,Cooling System Leakage-Refer Mechanic,Fan might not be Working-Refer Mechanic,Leaky Head Gasket-Refer Mechanic)) 
        (symptom engine-missfire-and-lack-of-acceleration-and-overheating-engine))
        )




(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,Car Tyres'Running long time' smells burning-Give a Rest to the Car,Driving belt might be slipping or loose-Refer Mechanic)) 
        (symptom blue-smoke-and-burning-rubber))
        )




(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom blue-smoke-and-burning-oil))
        )

(deffacts probelms
(probelm (name (create$ Fuel Leakage-Refer Mechanic,Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic)) 
        (symptom blue-smoke-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom blue-smoke-and-burning-carpet))
        )



(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom blue-smoke-and-burning-oil-and-burning-rubber))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,Fuel Leakage-Refer Mechanic)) 
        (symptom blue-smoke-and-burning-rubber-and-gasoline-smell))
        )



(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom blue-smoke-and-burning-carpet-and-burning-rubber))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Fuel Leakage-Refer Mechanic)) 
        (symptom blue-smoke-and-burning-oil-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom blue-smoke-and-burning-carpet-and-burning-oil))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Fuel Leakage-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom blue-smoke-and-burning-carpet-and-gasoline-smell))
        )


(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Fuel Leakage-Refer Mechanic)) 
        (symptom blue-smoke-and-burning-oil-and-burning-rubber-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom blue-smoke-and-burning-carpet-and-burning-oil-and-burning-rubber))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Fuel Leakage-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom blue-smoke-and-burning-carpet-and-burning-oil-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Fuel Leakage-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap,Bad clutch Plates might be burning-Refer Mechanic,Driving belt might be slipping or loose-Refer Mechanic)) 
        (symptom blue-smoke-and-burning-carpet-and-burning-oil-and-burning-rubber-and-gasoline-smell))
        )






(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,Car Tyres'Running long time' smells burning-Give a Rest to the Car,Driving belt might be slipping or loose-Refer Mechanic)) 
        (symptom black-smoke-and-burning-rubber))
        )




(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom black-smoke-and-burning-oil))
        )

(deffacts probelms
(probelm (name (create$ Fuel Leakage-Refer Mechanic,Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic)) 
        (symptom black-smoke-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom black-smoke-and-burning-carpet))
        )



(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom black-smoke-and-burning-oil-and-burning-rubber))
        )

(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,Fuel Leakage-Refer Mechanic)) 
        (symptom black-smoke-and-burning-rubber-and-gasoline-smell))
        )



(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom black-smoke-and-burning-carpet-and-burning-rubber))
        )

(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Fuel Leakage-Refer Mechanic)) 
        (symptom black-smoke-and-burning-oil-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom black-smoke-and-burning-carpet-and-burning-oil))
        )

(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,Fuel Leakage-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom black-smoke-and-burning-carpet-and-gasoline-smell))
        )


(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Fuel Leakage-Refer Mechanic)) 
        (symptom black-smoke-and-burning-oil-and-burning-rubber-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,Bad clutch Plates might be burning-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom black-smoke-and-burning-carpet-and-burning-oil-and-burning-rubber))
        )

(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,Fuel Leakage-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom black-smoke-and-burning-carpet-and-burning-oil-and-gasoline-smell))
        )

(deffacts probelms
(probelm (name (create$ Fuel Injector valve Problem-Refer Mechanic,Dust in Carpater-Clean Carpater,Problems with jets-Refer Mechanic,Fuel Leakage-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap,Bad clutch Plates might be burning-Refer Mechanic,Driving belt might be slipping or loose-Refer Mechanic)) 
        (symptom black-smoke-and-burning-carpet-and-burning-oil-and-burning-rubber-and-gasoline-smell))
        )





(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,Bad clutch Plates might be burning-Refer Mechanic,Car Tyres'Running long time' smells burning-Give a Rest to the Car,Driving belt might be slipping or loose-Refer Mechanic)) 
        (symptom burning-rubber-and-white-smoke))
        )




(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom burning-oil-and-white-smoke))
        )

(deffacts probelms
(probelm (name (create$ Fuel Leakage-Refer Mechanic,Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve)) 
        (symptom gasoline-smell-and-white-smoke))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom burning-carpet-and-white-smoke))
        )



(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,Bad clutch Plates might be burning-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom burning-oil-and-burning-rubber-and-white-smoke))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,Bad clutch Plates might be burning-Refer Mechanic,Fuel Leakage-Refer Mechanic)) 
        (symptom burning-rubber-and-gasoline-smell-and-white-smoke))
        )



(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,Bad clutch Plates might be burning-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom burning-carpet-and-burning-rubber-and-white-smoke))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Fuel Leakage-Refer Mechanic)) 
        (symptom burning-oil-and-gasoline-smell-and-white-smoke))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom burning-carpet-and-burning-oil-and-white-smoke))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,Fuel Leakage-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap)) 
        (symptom burning-carpet-and-gasoline-smell-and-white-smoke))
        )


(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,Bad clutch Plates might be burning-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic,Fuel Leakage-Refer Mechanic)) 
        (symptom burning-oil-and-burning-rubber-and-gasoline-smell-and-white-smoke))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,Bad clutch Plates might be burning-Refer Mechanic,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom burning-carpet-and-burning-oil-and-burning-rubber-and-white-smoke))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,Fuel Leakage-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap,OverHeated Engine or Broken temperature gauge-Refer Mechanic)) 
        (symptom burning-carpet-and-burning-oil-and-gasoline-smell-and-white-smoke))
        )

(deffacts probelms
(probelm (name (create$ Low Engine Oil-Check Engine Oil level,Weak Ring pistons-Refer Mechanic,Cylinder valve leak-Change Valve,Fuel Leakage-Refer Mechanic,Brake Issues Using brakes more than normally-Schedule a brake inspection asap,Bad clutch Plates might be burning-Refer Mechanic,Driving belt might be slipping or loose-Refer Mechanic)) 
        (symptom burning-carpet-and-burning-oil-and-burning-rubber-and-gasoline-smell-and-white-smoke))
        )



















  (defrule reading-input
   =>
  (printout t "" )
  (assert (var (read))))



 (defrule checking-input
 (var ?symptom)
 (probelm  (symptom ?symptom1)(name $?name1))
 (test (eq ?symptom ?symptom1)) 
   =>
  (printout t $?name1))