using System;

namespace InClass91918
{
    class PassFailCourse
    {
        public PassFailCourse(string name, string grade)
        {
            this.CourseName = name;
            if (grade.Equals("pass"))
            {
                this.Grade = true;
            }
            else if (grade.Equals("fail"))
            {
                this.Grade = false;
            }
        }

        string CourseName;
        bool Grade;

        public bool Passed()
        {
            return Grade;
        }

    }

    class GradedCourse
    {
        public GradedCourse(string name, decimal grade)
        {
            this.CourseName = name;
            this.Grade = grade;
        }

        string CourseName;
        decimal Grade;

        public bool Passed()
        {
            if(Grade >= 70)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    class Degree
    {
        public Degree(PassFailCourse pa, PassFailCourse pb, GradedCourse ga, GradedCourse gb)
        {
            this.PFCourseA = pa;
            this.PFCourseB = pb;
            this.GCourseA = ga;
            this.GCourseB = gb;
        }

        PassFailCourse PFCourseA;
        PassFailCourse PFCourseB;
        GradedCourse GCourseA;
        GradedCourse GCourseB;

        public bool Passed()
        {
            int passcount = 0;
            if (PFCourseA.Passed())
            {
                passcount += 1;
            }
            if (PFCourseB.Passed())
            {
                passcount += 1;
            }
            if (GCourseA.Passed())
            {
                passcount += 1;
            }
            if (GCourseB.Passed())
            {
                passcount += 1;
            }

            if (passcount >= 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

    }

    class Program
    {
        static void Main(string[] args)
        {
            PassFailCourse PA = new PassFailCourse("Math", "pass");
            PassFailCourse PB = new PassFailCourse("Literature", "fail");
            GradedCourse GA = new GradedCourse("Chemistry", 80);
            GradedCourse GB = new GradedCourse("Programming", 75);

            Degree degree = new Degree(PA, PB, GA, GB);
            if (degree.Passed())
            {
                Console.WriteLine("Passed");
            }
            else
            {
                Console.WriteLine("Failed");
            }

            Console.ReadKey();
        }
    }
}
