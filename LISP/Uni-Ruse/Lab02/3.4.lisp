;;;; 4 задача: Да се дефинира функция, която по зададена
;;;; стойност на х, определя f(x) по функцията:
;;;; 	f(x) = {
;;;; 		x > 5,  x^10-x^5+5
;;;; 		x <= 5, 100-x^20-x^15
;;;; 	}

;; Define function
(defun f (x)
  (cond 
    ((> x 5) (+ (- (expt x 10) (expt x 5)) 5))
    (t (- 100 (expt x 20) (expt x 15)))))

;; Call function
(f 1)
